package com.andybrook.manager.stock;

import org.springframework.data.util.Pair;

import java.util.List;

public interface IStockManager {

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);
}
