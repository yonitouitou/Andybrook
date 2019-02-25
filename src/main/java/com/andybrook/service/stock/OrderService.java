package com.andybrook.service.stock;

import com.andybrook.dao.stock.IOrderDao;
import com.andybrook.exception.StockReportClosed;
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
    private IOrderDao stockReportDao;
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
        return stockReportDao.newStockReport(report);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest request) throws OrderNotFound, StockReportClosed {
        Optional<StockReport> stockReportOpt = stockReportDao.findStockReport(request.getId());
        if (stockReportOpt.isPresent() && stockReportOpt.get().isOpen()) {
            stockReportDao.updateStockReport(request, false);
        } else {
            throw new StockReportClosed(request.getId());
        }
    }

    @Override
    public StockReport getStockReport(long id) throws OrderNotFound {
        return getStockReportById(id);
    }

    @Override
    public Set<StockReport> getAll() {
        return stockReportDao.getAll(adminSettingService.getOrdersNbToShow());
    }

    @Override
    public void addItemToReport(long stockReportId, StockItem<? extends Product> item) throws OrderNotFound {
        Optional<StockReport> stockReportOpt = stockReportDao.findStockReport(stockReportId);
        if (stockReportOpt.isPresent()) {
            StockReport stockReport = stockReportOpt.get();
            Product product = item.getProduct();
            if (product.getId() == null) {
                product.setId(IdGenerator.generateId());
            }
            stockReport.addItem(item);
            stockReportDao.updateStockReport(stockReport);
        } else {
            throw new OrderNotFound(languageResolver.get(STOCK_REPORT_NOT_FOUND + " : " + stockReportId));
        }
    }

    @Override
    public StockReport closeStockReport(long id) throws OrderNotFound, StockReportClosed {
        StockReport report = getStockReport(id);
        report.close();
        return stockReportDao.updateStockReport(report);
    }

    private StockReport getStockReportById(long id) throws OrderNotFound {
        Optional<StockReport> reportOpt = stockReportDao.findStockReport(id);
        if (! reportOpt.isPresent()) {
            throw new OrderNotFound(languageResolver.get(STOCK_REPORT_NOT_FOUND + " : " + id));
        }
        return reportOpt.get();
    }

    @Override
    public List<StockReport> getOrdersByName(String name) {
        return stockReportDao.getByName(name);
    }

    @Override
    public List<StockReport> getOrderByNameContaining(String name) {
        return stockReportDao.getByNameContaining(name);
    }

    @Override
    public List<StockReport> getOrders(List<Long> ids) {
        return stockReportDao.getOrders(ids);
    }
}
