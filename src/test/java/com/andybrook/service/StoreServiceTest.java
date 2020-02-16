package com.andybrook.service;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.generator.OwnerGenerator;
import com.andybrook.generator.StoreGenerator;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.service.owner.IOwnerService;
import com.andybrook.service.store.IStoreService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreServiceTest {

    @Autowired
    private IStoreService storeService;
    @Autowired
    private IOwnerService ownerService;

    @Test
    public void newStoreOfNewOwnerTest() {
        Store store = StoreGenerator.generateStore();
        storeService.newStore(store);
        Store persistedStore = storeService.getById(store.getId());
        Owner persistedOwner = ownerService.get(store.getOwner().getId());
        Assert.assertNotNull(persistedStore);
        Assert.assertNotNull(persistedOwner);
    }

    @Test
    public void newStoreOfExistingOwnerTest() {
        Store store = StoreGenerator.generateStore();
        ownerService.newOwner(store.getOwner());
        storeService.newStore(store);
        Store persistedStore = storeService.getById(store.getId());
        Assert.assertNotNull(persistedStore);
    }

    @Test(expected = StoreNotFound.class)
    public void updateInexistantStoreTest() {
        Store store = StoreGenerator.generateStore();
        store.setId(1234L);
        storeService.update(store);
    }

    @Test
    public void getStoresOfOwnerTest() {
        Owner owner = OwnerGenerator.generateOwner();
        ownerService.newOwner(owner);
        Store store1 = StoreGenerator.generateStore(owner);
        Store store2 = StoreGenerator.generateStore(owner);
        storeService.newStore(store1);
        storeService.newStore(store2);
        Map<Long, Store> storesOfOwner = storeService.getStoresOfOwner(owner.getId());
        Assert.assertEquals(2, storesOfOwner.size());
        storesOfOwner.values()
                .forEach(store -> Assert.assertTrue(store.getId() == store1.getId() || store.getId() == store2.getId()));
    }

}
