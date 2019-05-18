package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.customer.AddOrUpdateCustomerRestRequest;
import com.andybrook.manager.customer.ICustomerManager;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderInfo;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.model.request.customer.AddCustomerRequest.Builder;
import com.andybrook.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/customer")
public class CustomerController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CustomerController.class.getSimpleName());

    @Autowired
    private ICustomerManager customerManager;
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @PostMapping(path = "/add")
    public void newCustomer(@RequestBody AddOrUpdateCustomerRestRequest request) {
        LOGGER.log(Level.INFO, "New Customer request : " + request.toString());
        customerManager.newCustomer(toCustomerRequest(request));
    }

    @GetMapping(path = "/get/{id}")
    public Customer getCustomer(@PathVariable long id) {
        LOGGER.log(Level.INFO, "Get Customer request with id : " + id);
        return customerManager.get(id);
    }

    @PostMapping(path = "/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        LOGGER.log(Level.INFO, "Update Customer request : " + customer);
        return customerManager.updateCustomer(customer);
    }

    @GetMapping(path = "/searchByIdOrName/{input}")
    public List<Customer> searchByIdOrName(@PathVariable String input) {
        LOGGER.log(Level.INFO, "Search customer request received by input : " + input);
        Long inputAsLong = NumberUtil.parseNumber(input, Long.class);
        List<Customer> customers = Collections.emptyList();
        if (inputAsLong != null) {
            if (inputAsLong > 0) {
                customers = List.of(customerManager.get(inputAsLong));
            }
        } else {
            customers = customerManager.getByNameContaining(input.trim());
        }
        return customers;
    }

    @GetMapping(path = "/storesOfOwner/{ownerId}")
    public Collection<Store> getStoresOfOwner(@PathVariable long ownerId) {
        LOGGER.log(Level.INFO, "Get stores of owner : " + ownerId);
        return customerManager.getStoresOfOwner(ownerId).values();
    }

    @GetMapping(path = "/allOwnerIdsAndNames")
    public List<Pair<Long, String>> getAllOwnerIdsAndNames() {
        List<Pair<Long, String>> l = new LinkedList<>();
        LOGGER.log(Level.INFO, "Get all owners ids and names request");
        return customerManager.getAllOwners()
                .values()
                .stream()
                .map(owner -> Pair.of(owner.getId(), owner.getCompagnyName()))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/all")
    public List<Customer> getAll() {
        LOGGER.log(Level.INFO, "Get All customer request with limit");
        return customerManager.getAll(OptionalInt.of(adminSettingManager.getLoadItemsLimit()));
    }

    @GetMapping(path = "/allNoLimit")
    public List<Customer> getAllNoLimit() {
        LOGGER.log(Level.INFO, "Get All customer request no limit.");
        return customerManager.getAll(OptionalInt.empty());
    }

    private AddCustomerRequest toCustomerRequest(AddOrUpdateCustomerRestRequest req) {
        Builder builder = req.getOwnerId() != null
                ? AddCustomerRequest.builder(req.getOwnerId(), req.getStoreName())
                : AddCustomerRequest.builder(req.getOwnerCompagnyName(), req.getStoreName());
        return builder.setOwnerEmail(req.getOwnerEmail())
                .setOwnerFirstName(req.getOwnerFirstName())
                .setOwnerLastName(req.getOwnerLastName())
                .setStoreAddress(req.getStoreAddress())
                .setStoreEmail(req.getStoreEmail())
                .setStorePhone(req.getStorePhone())
                .build();
    }
}
