package com.andybrook.manager;

import com.andybrook.manager.store.IStoreManager;
import com.andybrook.model.common.Address;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreManagerTest {

    @Autowired
    private IStoreManager storeManager;

    @Test
    public void create5Stores() {
        Owner owner = new Owner("MyCompagny", "John", "Durant", "john.durant@gmail.com");
        Address a1 = new Address("1", "avenue de la Riviere", "Paris", "France", 75020);
        Store store = new Store("MyStore", "myStore@gmail.com", "01.34.78.65.34", a1, owner);
        Address a2 = new Address("5", "avenue du General De Gaulle", "Paris", "France", 75002);
        Store store3 = new Store("MyStore3", "myStore3@gmail.com", "01.35.67.32.22", a2, owner);

        Owner owner2 = new Owner("MyCompagny2", "Stephane", "Herot", "stephane.herot@gmail.com");
        Address a3 = new Address("14", "avenue du Signe", "Paris", "France", 75006);
        Store store2 = new Store("MyStore2", "myStore2@gmail.com", "03.32.44.55.23", a3, owner2);

        storeManager.newStore(store);
        storeManager.newStore(store2);
        storeManager.newStore(store3);
    }
}
