package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.Product;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
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
        Map<Long, StockItem<? extends Product>> products = new HashMap<>(items);
        return new StockReport(entity.getId(), entity.getName(), products);
    }

    @Override
    public StockReportEntity toEntity(StockReport model) {
        List<StockItemEntity> items = model.getProductsAsList()
                .stream()
                .map(s -> entityFactory.createStockItemEntityByProductType(s))
                .collect(Collectors.toList());
        return new StockReportEntity(model.getId(), model.getName(), items, model.getStatus());
    }
}
