package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockReportDao;
import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

@Service
public class StockReportService implements IStockReportService {

    @Autowired
    private IStockReportDao stockReportDao;

    @Override
    public StockReport newStockReport(NewStockReportRequest request) {
        StockReport report = new StockReport(null, request.getName(), new HashMap<>());
        report.setComment(request.getComment());
        return stockReportDao.newStockReport(report);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest request) throws StockReportNotFound, StockReportClosed {
        Optional<StockReport> stockReportOpt = stockReportDao.getStockReport(request.getId());
        if (stockReportOpt.isPresent() && stockReportOpt.get().isOpen()) {
            stockReportDao.updateStockReport(request, false);
        } else {
            throw new StockReportClosed(request.getId());
        }
    }

    @Override
    public StockReport getStockReport(long id) throws StockReportNotFound {
        return getStockReportById(id);
    }

    @Override
    public Set<StockReport> getAll() {
        return stockReportDao.getAll();
    }

    @Override
    public void addItemToReport(long stockReportId, StockItem<? extends Product> item) throws StockReportNotFound {
        Optional<StockReport> stockReportOpt = stockReportDao.getStockReport(stockReportId);
        if (stockReportOpt.isPresent()) {
            StockReport stockReport = stockReportOpt.get();
            Product product = item.getProduct();
            if (product.getId() == null) {
                product.setId(IdGenerator.generateId());
            }
            stockReport.addItem(item);
            stockReportDao.updateStockReport(stockReport);
        } else {
            throw new StockReportNotFound(stockReportId);
        }
    }

    @Override
    public void closeStockReport(long id) throws StockReportNotFound, StockReportClosed {
        StockReport report = getStockReport(id);
        if (report.isClosed()) {
            throw new StockReportClosed(id);
        }
        stockReportDao.closeStockReport(id);
    }

    private StockReport getStockReportById(long id) throws StockReportNotFound {
        StockReport report;
        Optional<StockReport> stockReportOpt = stockReportDao.getStockReport(id);
        if (stockReportOpt.isPresent()) {
            report = stockReportOpt.get();
        } else {
            throw new StockReportNotFound(id);
        }
        return report;
    }
}
