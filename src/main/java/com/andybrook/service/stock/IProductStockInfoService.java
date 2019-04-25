package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IProductStockInfoService {

    void add(long productId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);

    int getFreeQuantity(long productId);

    int getCreatedQuantity(long productId);

    int getUsedQuantity(long productId);

    boolean isFreeQuantityExist(long productId);

    void incrementQuantityUsed(long productId);

    void incrementQuantityCreated(long productId);

    void decrementQuantityUsed(long productId);

    void decrementQuantityCreated(long productId);
}
