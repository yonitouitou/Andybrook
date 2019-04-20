package com.andybrook.service.stock;

import org.springframework.data.util.Pair;

import java.util.List;

public interface IProductStockInfoService {

    void update(long productId, int quantityCreated, int quantityUsed);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);

    int getFreeQuantity(long productId);

    boolean isFreeQuantityExist(long productId);

    void incrementQuantityUsed(long productId);
}
