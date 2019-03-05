package com.andybrook.service.stock;

import com.andybrook.dao.stock.IOrderDao;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.language.LanguageResolver;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.setting.IAdminSettingService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.andybrook.language.Msg.Error.STOCK_REPORT_NOT_FOUND;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private LanguageResolver languageResolver;
    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    public StockReport newStockReport(NewStockReportRequest request) {
        Customer customer = customerService.getById(request.getCustomerId());
        StockReport report = new StockReport(null, request.getName(), customer, new HashMap<>());
        report.setComment(request.getComment());
        return orderDao.newStockReport(report);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest request) throws OrderNotFound, OrderClosed {
        Optional<StockReport> stockReportOpt = orderDao.findStockReport(request.getId());
        if (stockReportOpt.isPresent() && stockReportOpt.get().isOpen()) {
            orderDao.updateStockReport(request, false);
        } else {
            throw new OrderClosed(request.getId());
        }
    }

    @Override
    public StockReport getOrder(long id) throws OrderNotFound {
        return getOrderById(id);
    }

    @Override
    public Set<StockReport> getAll() {
        return orderDao.getAll(adminSettingService.getOrdersNbToShow());
    }

    @Override
    public void addItemToReport(long stockReportId, StockItem<? extends Product> item) throws OrderNotFound {
        Optional<StockReport> stockReportOpt = orderDao.findStockReport(stockReportId);
        if (stockReportOpt.isPresent()) {
            StockReport stockReport = stockReportOpt.get();
            Product product = item.getProduct();
            if (product.getId() == null) {
                product.setId(IdGenerator.generateId());
            }
            stockReport.addItem(item);
            orderDao.updateStockReport(stockReport);
        } else {
            throw new OrderNotFound(languageResolver.get(STOCK_REPORT_NOT_FOUND + " : " + stockReportId));
        }
    }

    @Override
    public StockReport closeStockReport(long id) throws OrderNotFound, OrderClosed {
        StockReport report = getOrder(id);
        report.close();
        return orderDao.updateStockReport(report);
    }

    @Override
    public List<StockReport> getOrdersByName(String name) {
        return orderDao.getByName(name);
    }

    @Override
    public List<StockReport> getOrderByNameContaining(String name) {
        return orderDao.getByNameContaining(name);
    }

    @Override
    public List<StockReport> getOrders(List<Long> ids) {
        return orderDao.getOrders(ids);
    }

    @Override
    public boolean canModifyOrder(long id) throws OrderNotFound {
        StockReport order = getOrder(id);
        return order.isOpen();
    }

    private StockReport getOrderById(long id) throws OrderNotFound {
        Optional<StockReport> reportOpt = orderDao.findStockReport(id);
        if (! reportOpt.isPresent()) {
            throw new OrderNotFound(languageResolver.get(STOCK_REPORT_NOT_FOUND + " : " + id));
        }
        return reportOpt.get();
    }
}
