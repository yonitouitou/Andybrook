package com.andybrook.service.statistic;

import com.andybrook.dao.statistic.IOrdersStatisticDao;
import com.andybrook.model.order.Order;
import com.andybrook.model.statistic.order.AmountAndProductsOrdersSet;
import com.andybrook.model.statistic.order.AmountAndProductsOrdersSet.AmountOrderSetItem;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;
import com.andybrook.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersStatisticService implements IOrdersStatisticService {

    @Autowired
    private IOrdersStatisticDao dao;
    @Autowired
    private IOrderService orderService;

    @Override
    public OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId) {
        return dao.getOpenClosedOrdersCounterByStore(storeId);
    }

    @Override
    public AmountAndProductsOrdersSet getLastAmountOrders(long storeId, int nbOfLastOrders) {
        AmountAndProductsOrdersSet set = new AmountAndProductsOrdersSet();
        List<Order> orders = orderService.getLastOrdersOfStore(storeId, nbOfLastOrders);
        for (Order order : orders) {
            double amount = orderService.getAmount(order);
            AmountOrderSetItem item = new AmountOrderSetItem(order.getId(), order.getName(), amount);
            set.addAmountOrderSetItem(item);
        }
        return set;
    }
}
