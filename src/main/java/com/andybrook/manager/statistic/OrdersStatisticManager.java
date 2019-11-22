package com.andybrook.manager.statistic;

import com.andybrook.model.statistic.order.AmountAndProductsOrdersSet;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;
import com.andybrook.service.statistic.OrdersStatisticService;
import com.andybrook.util.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersStatisticManager implements IOrdersStatisticManager {

    @Autowired
    private OrdersStatisticService ordersStatisticService;

    public OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId) {
        return ordersStatisticService.getOpenClosedOrdersCounterByStore(storeId);
    }

    @Override
    public AmountAndProductsOrdersSet getLastAmountOrders(long storeId, int nbOfLastOrders) {
        Arg.requireStrictPositiveNumber(nbOfLastOrders);
        return ordersStatisticService.getLastAmountOrders(storeId, nbOfLastOrders);
    }
}
