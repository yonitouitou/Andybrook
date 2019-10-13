package com.andybrook.service.statistic;

import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;

public interface IOrdersStatisticService {

    OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId);
}
