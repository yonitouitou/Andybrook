package com.andybrook.service.customer;

import com.andybrook.assertor.CustomerAssertor;
import com.andybrook.exception.CustomerNotFound;
import com.andybrook.model.common.Address;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.model.request.customer.UpdateCustomerRequest;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.util.clock.Clock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.andybrook.generator.CustomerGenerator.createAddCustomerRequest;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Autowired
    private ICustomerService customerService;

    private Owner owner;
    private Store store;
    private Customer customer;
    private AddCustomerRequest addCustomerRequest;

    @Before
    public void init() {
        addCustomerRequest = createAddCustomerRequest(Clock.millis());
    }

    @Test
    public void createSingleCustomerTest() {
        Customer savedCustomer = customerService.newCustomer(addCustomerRequest);
        Assert.assertNotNull(savedCustomer.getId());
        //CustomerAssertor.assertEqualsStaticField(addCustomerRequest.toCustomer(), savedCustomer);
    }

    @Test
    public void getCustomerTest() {
        Customer savedCustomer = customerService.newCustomer(addCustomerRequest);
        Customer getCustomer = customerService.getById(savedCustomer.getId());
        CustomerAssertor.assertEquals(savedCustomer, getCustomer);
    }

    @Test
    public void getOwnersSizeTest() {
        int nbOwnerToCreate = 3;
        int currentOwnersSize = customerService.getAllOwners().size();
        for (int i = 0; i < nbOwnerToCreate; i++) {
            customerService.newCustomer(createAddCustomerRequest(Clock.nanos()));
        }
        Map<Long, Owner> owners = customerService.getAllOwners();
        Assert.assertEquals("Owner Size", currentOwnersSize + nbOwnerToCreate, owners.size());
    }

    @Test
    public void updateCustomerTest() {
        customer = customerService.newCustomer(addCustomerRequest);
        String ownerCompagnyName = "CompagnyName1";
        String ownerEmail = "NewOwnerEmail@gmail.com";
        String ownerFirstName = "NewFirstName";
        String ownerLastName = "NewLastName";
        String storeName = "NewStoreName";
        String storeEmail = "NewStoreEmail@gmail.com";
        String storePhone = "01.34.87.54.66";
        Address storeAddress = new Address("18", "avenue de la Paix", "Paris", "France", 75009);
        UpdateCustomerRequest request = UpdateCustomerRequest.builder(customer.getId())
                .setOwnerCompagnyName(ownerCompagnyName)
                .setOwnerEmail(ownerEmail)
                .setOwnerFirstName(ownerFirstName)
                .setOwnerLastName(ownerLastName)
                .setStoreAddress(storeAddress)
                .setStoreEmail(storeEmail)
                .setStoreName(storeName)
                .setStorePhone(storePhone)
                .build();
        Customer updatedCustomer = customerService.updateCustomer(request);
        Assert.assertEquals("Id", customer.getId(), updatedCustomer.getId());
        Store updatedStore = updatedCustomer.getStore();
        Owner updatedOwner = updatedStore.getOwner();
        Assert.assertEquals("Owner.CompagnyName", ownerCompagnyName, updatedOwner.getCompagnyName());
        Assert.assertEquals("Owner.FirstName", ownerFirstName, updatedOwner.getFirstName());
        Assert.assertEquals("Owner.LastName", ownerLastName, updatedOwner.getLastName());
        Assert.assertEquals("Owner.Email", ownerEmail, updatedOwner.getEmail());
        Assert.assertEquals("Store.Name", storeName, updatedStore.getName());
        Assert.assertEquals("Store.Email", storeEmail, updatedStore.getEmail());
        Assert.assertEquals("Store.Phone", storePhone, updatedStore.getPhone());
        Assert.assertEquals("Store.Address", storeAddress, updatedStore.getAddress());
    }

    @Test(expected = CustomerNotFound.class)
    public void getInexistentCustomerTest() {
        customerService.getById(Long.MAX_VALUE);
    }


}
