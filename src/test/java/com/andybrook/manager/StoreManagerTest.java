package com.andybrook.manager;

import com.andybrook.manager.store.IStoreManager;
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
        Owner owner = new Owner("John", "Durant", "john.durant@gmail.com");
        Store store = new Store("MyStore", "myStore@gmail.com", "15 avenue du 8 mai 1945", owner);
        Store store3 = new Store("MyStore3", "myStore3@gmail.com", "5 avenue du General De Gaulle", owner);

        Owner owner2 = new Owner("Stephane", "Herot", "stephane.herot@gmail.com");
        Store store2 = new Store("MyStore2", "myStore2@gmail.com", "3 avenue du Paul Valery", owner2);

        storeManager.newStore(store);
        storeManager.newStore(store2);
        storeManager.newStore(store3);
    }
}