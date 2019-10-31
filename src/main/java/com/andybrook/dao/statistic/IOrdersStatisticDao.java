package com.andybrook.dao.statistic;

import com.andybrook.model.statistic.order.AmountOrdersSet;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;

public interface IOrdersStatisticDao {

    OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId);

    AmountOrdersSet getLastAmountOrders(long storeId, int nbOfLastOrders);
}
