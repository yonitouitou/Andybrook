package com.andybrook.api.rest;

import com.andybrook.manager.store.IStoreManager;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/store")
public class StoreController extends AbstractController {

    private static System.Logger LOGGER = System.getLogger(StoreController.class.getSimpleName());

    @Autowired
    private IStoreManager storeManager;

    @GetMapping(path = "/get/{id}")
    public Store getStore(@PathVariable long id) {
        LOGGER.log(System.Logger.Level.INFO, "Get store with id : " + id);
        return storeManager.getById(id);
    }
}
