package com.andybrook.service.statistic;

import com.andybrook.dao.statistic.IOrdersStatisticDao;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersStatisticService implements IOrdersStatisticService {

    @Autowired
    private IOrdersStatisticDao dao;

    @Override
    public OpenClosedOrdersCounter getOpenClosedOrdersCounterByStore(long storeId) {
        return dao.getOpenClosedOrdersCounterByStore(storeId);
    }
}
