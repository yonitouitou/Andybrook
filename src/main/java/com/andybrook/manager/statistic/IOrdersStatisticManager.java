package com.andybrook.manager.statistic;

import com.andybrook.model.statistic.order.AmountAndProductsOrdersSet;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;

public interface IOrdersStatisticManager {

    OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId);

    AmountAndProductsOrdersSet getLastAmountOrders(long storeId, int nbOfLastOrders);
}
