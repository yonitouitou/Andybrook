package com.andybrook.service.statistic;

import com.andybrook.model.statistic.order.AmountOrdersSet;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;

public interface IOrdersStatisticService {

    OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId);

    AmountOrdersSet getLastAmountOrders(long storeId, int nbOfLastOrders);
}
