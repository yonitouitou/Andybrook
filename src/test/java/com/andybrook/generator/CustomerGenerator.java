package com.andybrook.generator;

import com.andybrook.model.customer.Customer;

public final class CustomerGenerator {

    public static final Customer generateCustomer() {
        return new Customer(StoreGenerator.generateStore());
    }
}
