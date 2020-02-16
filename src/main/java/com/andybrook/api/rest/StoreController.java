package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.customer.AddOrUpdateStoreRestRequest;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.manager.store.IStoreManager;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddStoreRequest;
import com.andybrook.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

@RestController
@RequestMapping("v1/store")
public class StoreController extends AbstractController {

    private static System.Logger LOGGER = System.getLogger(StoreController.class.getSimpleName());

    @Autowired
    private IStoreManager storeManager;
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @PostMapping(path = "/add")
    public void newCustomer(@RequestBody AddOrUpdateStoreRestRequest request) {
        LOGGER.log(System.Logger.Level.INFO, "New Store request : " + request.toString());
        storeManager.newStore(toStoreRequest(request));
    }

    @GetMapping(path = "/get/{id}")
    public Store getStore(@PathVariable long id) {
        LOGGER.log(System.Logger.Level.INFO, "Get store with id : " + id);
        return storeManager.getById(id);
    }

    @GetMapping(path = "/searchByIdOrName/{input}")
    public List<Store> searchByIdOrName(@PathVariable String input) {
        LOGGER.log(System.Logger.Level.INFO, "Search customer request received by input : " + input);
        Long inputAsLong = NumberUtil.parseNumber(input, Long.class);
        List<Store> stores = Collections.emptyList();
        if (inputAsLong != null) {
            if (inputAsLong > 0) {
                stores = List.of(storeManager.getById(inputAsLong));
            }
        } else {
            stores = storeManager.getByNameContaining(input.trim());
        }
        return stores;
    }

    @PostMapping(path = "/update")
    public Store update(@RequestBody Store store) {
        LOGGER.log(System.Logger.Level.INFO, "Update store : " + store.toString());
        storeManager.update(store);
        return store;
    }

    @GetMapping(path = "/all")
    public List<Store> getAll() {
        LOGGER.log(System.Logger.Level.INFO, "Get All customer request with limit");
        return storeManager.getAll(OptionalInt.of(adminSettingManager.getLoadItemsLimit()));
    }

    @GetMapping(path = "/allNoLimit")
    public List<Store> getAllNoLimit() {
        LOGGER.log(System.Logger.Level.INFO, "Get All customer request no limit.");
        return storeManager.getAll(OptionalInt.empty());
    }

    private AddStoreRequest toStoreRequest(AddOrUpdateStoreRestRequest req) {
        AddStoreRequest.Builder builder = req.getOwnerId() != null
                ? AddStoreRequest.builder(req.getOwnerId(), req.getStoreName())
                : AddStoreRequest.builder(req.getOwnerCompagnyName(), req.getStoreName());
        return builder.setOwnerEmail(req.getOwnerEmail())
                .setOwnerFirstName(req.getOwnerFirstName())
                .setOwnerLastName(req.getOwnerLastName())
                .setStoreAddress(req.getStoreAddress())
                .setStoreEmail(req.getStoreEmail())
                .setStorePhone(req.getStorePhone())
                .build();
    }
}
