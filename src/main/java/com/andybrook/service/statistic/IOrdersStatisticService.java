package com.andybrook.service.statistic;

import com.andybrook.model.statistic.order.AmountAndProductsOrdersSet;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;

public interface IOrdersStatisticService {

    OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId);

    AmountAndProductsOrdersSet getLastAmountOrders(long storeId, int nbOfLastOrders);
}
