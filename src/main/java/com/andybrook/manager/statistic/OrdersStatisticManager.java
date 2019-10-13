package com.andybrook.manager.statistic;

import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;
import com.andybrook.service.statistic.OrdersStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersStatisticManager implements IOrdersStatisticManager {

    @Autowired
    private OrdersStatisticService ordersStatisticService;

    public OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId) {
        return ordersStatisticService.getOpenClosedOrdersCounterByStore(storeId);
    }
}
