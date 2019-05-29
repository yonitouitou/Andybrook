package com.andybrook.generator;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.request.customer.AddCustomerRequest;

public final class CustomerGenerator {

    public static final Customer generateCustomer() {
        return new Customer(StoreGenerator.generateStore());
    }

    public static final AddCustomerRequest createAddCustomerRequest(long random) {
        return AddCustomerRequest.builder("Compagny_" + random, "Optika_" + random)
                .setOwnerFirstName("Steve_" + random)
                .setOwnerLastName("Smith")
                .setOwnerEmail("steve_" + random +".smith@optika.net")
                .setStoreStreetNumber("" + random)
                .setStoreStreetName("Avenue Paul Valery")
                .setStoreZipCode(75012)
                .setStoreCity("Paris")
                .setStoreCountry("France")
                .setStorePhone("01.34.77.54.22")
                .setStoreEmail("optika_" + random + "@gmail.com")
                .build();
    }
}
