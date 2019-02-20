package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@EntityConverter(model = StockReport.class, entity = StockReportEntity.class)
public class StockReportEntityConverter implements IEntityConverter<StockReport, StockReportEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockReport toModel(StockReportEntity entity) {
        Map<Long, StockItem<Product>> items = entity.getItems()
                .stream()
                .map(e -> entityFactory.createStockItem(e))
                .collect(Collectors.toMap(StockItem::getId, Function.identity()));
        Customer customer = entityFactory.createCustomer(entity.getCustomerEntity());
        Map<Long, StockItem<? extends Product>> products = new HashMap<>(items);
        StockReport report = new StockReport(entity.getId(), entity.getName(), customer, products);
        report.setStatus(entity.getStatus());
        report.setComment(entity.getComment());
        report.setCloseDateTime(entity.getCloseDatetime());
        return report;
    }

    @Override
    public StockReportEntity toEntity(StockReport model) {
        List<StockItemEntity> items = model.getItems()
                .stream()
                .map(s -> entityFactory.createStockItemEntityByProductType(s))
                .collect(Collectors.toList());
        CustomerEntity customerEntity = entityFactory.createCustomerEntity(model.getCustomer());
        return new StockReportEntity(model.getId(), model.getName(), customerEntity, items,
                model.getStatus(), model.getComment(), model.getCloseDateTime());
    }
}
