package com.andybrook.api.rest;

import com.andybrook.manager.statistic.IOrdersStatisticManager;
import com.andybrook.model.statistic.order.OpenClosedOrdersCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/os")
public class OrdersStatisticController {

    @Autowired
    private IOrdersStatisticManager ordersStatisticManager;

    @GetMapping(path = "/openClosedByStore/{storeId}")
    public OpenClosedOrdersCounter openClosedOrdersOfStoreCounter(@PathVariable Long storeId) {
        return ordersStatisticManager.getOpenClosedOrdersCounterByStore(storeId);
    }
}
