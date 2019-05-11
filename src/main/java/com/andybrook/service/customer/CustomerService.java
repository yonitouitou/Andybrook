package com.andybrook.service.customer;

import com.andybrook.dao.customer.ICustomerDao;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.service.owner.IOwnerService;
import com.andybrook.service.store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Customer getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return dao.getAll();
    }

    @Override
    public Map<Long, Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @Override
    public Map<Long, Store> getStoresOfOwner(long ownerId) {
        return storeService.getStoresOfOwner(ownerId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return update(customer);
    }

    private Customer update(Customer customer) {
        return dao.update(customer);
    }

    public Customer toCustomer(AddCustomerRequest req) {
        Owner owner = req.getOwnerId() != null
                ? ownerService.get(req.getOwnerId())
                : createOwner(req);
        Store store = createStore(req, owner);
        return new Customer(store);
    }

    private Owner createOwner(AddCustomerRequest req) {
        return new Owner(req.getOwnerCompagnyName(), req.getOwnerFirstName(), req.getOwnerLastName(), req.getOwnerEmail());
    }

    private Store createStore(AddCustomerRequest req, Owner owner) {
        return new Store(req.getStoreName(), req.getStoreEmail(), req.getStoreAddress(), req.getStorePhone(), owner);
    }

    private boolean shouldCreateOwner(Customer customer) {
        return customer.getStore().getOwner().getId() == null;
    }
}
