package com.andybrook.dao.statistic;

import com.andybrook.enums.OrderStatus;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class OrdersStatisticDao implements IOrdersStatisticDao {

    @Autowired
    private IOrdersStatisticRepository repository;

    @Override
    public OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId) {
        OpenClosedOrdersCounter openClosedOrdersCounter = OpenClosedOrdersCounter.zero();
        List<Object[]> counters = repository.getOrdersOfStoreByStatusCounter(storeId);
        if (! counters.isEmpty()) {
            openClosedOrdersCounter = new OpenClosedOrdersCounter();
            for (Object[] o : counters) {
                OrderStatus status = OrderStatus.values()[(int) o[0]];
                long counter = ((BigInteger) o[1]).longValue();
                openClosedOrdersCounter.addCounter(status, counter);
            }
        }
        return openClosedOrdersCounter;
    }
}
