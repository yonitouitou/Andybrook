package com.andybrook.generator;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.request.customer.AddCustomerRequest;

public final class CustomerGenerator {

    public static final Customer generateCustomer() {
        return new Customer(StoreGenerator.generateStore());
    }

    public static final AddCustomerRequest createAddCustomerRequest(long random) {
        return AddCustomerRequest.builder("Steve_" + random, "Smith", "Optika_" + random)
                .setOwnerEmail("steve_" + random +".smith@optika.net")
                .setStoreAddress(random + " Avenue Paul Valery - Paris")
                .setStorePhone("01.34.77.54.22")
                .setStoreEmail("optika_" + random + "@gmail.com")
                .build();
    }
}
