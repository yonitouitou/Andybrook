package com.andybrook.service.customer;

import com.andybrook.dao.customer.ICustomerDao;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.model.request.customer.UpdateCustomerRequest;
import com.andybrook.service.owner.IOwnerService;
import com.andybrook.service.store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDao dao;
    @Autowired
    private IOwnerService ownerService;
    @Autowired
    private IStoreService storeService;

    @Override
    public Customer newCustomer(AddCustomerRequest request) {
        Customer customer = toCustomer(request);
        if (shouldCreateOwner(customer)) {
            Owner owner = ownerService.update(customer.getStore().getOwner());
            customer.getStore().setOwner(owner);
        }
        return update(customer);
    }

    @Override
    public Customer updateCustomer(UpdateCustomerRequest request) {
        Customer customer = getById(request.getCustomerId());
        return updateCustomer(customer, request);
    }

    @Override
    public Customer getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Customer> getByNameContaining(String name) {
        return dao.getByNameContaining(name);
    }

    @Override
    public List<Customer> getAll(OptionalInt limitOpt) {
        return dao.getAll(limitOpt);
    }

    @Override
    public Map<Long, Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @Override
    public Map<Long, Store> getStoresOfOwner(long ownerId) {
        return storeService.getStoresOfOwner(ownerId);
    }

    private Customer update(Customer customer) {
        return dao.update(customer);
    }

    private Customer toCustomer(AddCustomerRequest req) {
        Owner owner = req.getOwnerId() != null
                ? ownerService.get(req.getOwnerId())
                : createOwner(req);
        Store store = createStore(req, owner);
        return new Customer(store);
    }

    private Customer updateCustomer(Customer customer, UpdateCustomerRequest request) {
        Store store = customer.getStore();
        store.setName(request.getStoreName());
        store.setAddress(request.getStoreAddress());
        store.setEmail(request.getStoreEmail());
        store.setPhone(request.getStorePhone());

        Owner owner = store.getOwner();
        owner.setCompagnyName(request.getOwnerCompagnyName());
        owner.setFirstName(request.getOwnerFirstName());
        owner.setLastName(request.getOwnerLastName());
        owner.setEmail(request.getOwnerEmail());

        return update(customer);
    }

    private Owner createOwner(AddCustomerRequest req) {
        return new Owner(req.getOwnerCompagnyName(), req.getOwnerFirstName(), req.getOwnerLastName(), req.getOwnerEmail());
    }

    private Store createStore(AddCustomerRequest req, Owner owner) {
        return new Store(req.getStoreName(), req.getStoreEmail(), req.getStorePhone(), req.getStoreAddress(), owner);
    }

    private boolean shouldCreateOwner(Customer customer) {
        return customer.getStore().getOwner().getId() == null;
    }
}
