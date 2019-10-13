package com.andybrook.dao.statistic;

import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;

public interface IOrdersStatisticDao {

    OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId);
}
