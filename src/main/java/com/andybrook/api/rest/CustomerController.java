package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.customer.AddOrUpdateCustomerRestRequest;
import com.andybrook.manager.customer.ICustomerManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderInfo;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.model.request.customer.AddCustomerRequest.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/customer")
public class CustomerController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CustomerController.class.getSimpleName());

    @Autowired
    private ICustomerManager customerManager;

    @PostMapping(path = "/add")
    public void newCustomer(@RequestBody AddOrUpdateCustomerRestRequest request) {
        LOGGER.log(Level.INFO, "New Customer request : " + request.toString());
        customerManager.newCustomer(toCustomerRequest(request));
    }

    @PostMapping(path = "/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        LOGGER.log(Level.INFO, "Update Customer request : " + customer);
        return customerManager.updateCustomer(customer);
    }

    @GetMapping(path = "/allOwnerIdsAndNames")
    public List<Pair<Long, String>> getAllOwnerIdsAndNames() {
        List<Pair<Long, String>> l = new LinkedList<>();
        LOGGER.log(Level.INFO, "Get all owners ids and names request");
        return customerManager.getAllOwners()
                .values()
                .stream()
                .map(owner -> Pair.of(owner.getId(), owner.getFirstName() + " " + owner.getLastName()))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/all")
    public List<Customer> getAll() {
        LOGGER.log(Level.INFO, "Get All customer request.");
        return customerManager.getAll();
    }

    private AddCustomerRequest toCustomerRequest(AddOrUpdateCustomerRestRequest req) {
        return AddCustomerRequest.builder(req.getOwnerFirstName(), req.getOwnerLastName(), req.getStoreName())
                .setOwnerEmail(req.getOwnerEmail())
                .setStoreAddress(req.getStoreAddress())
                .setStoreEmail(req.getStoreEmail())
                .setStorePhone(req.getStorePhone())
                .build();
    }
}
