package com.andybrook.assertor;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import org.junit.Assert;

public final class CustomerAssertor {

    private static final String STORE_PREFIX = Store.class.getSimpleName() + ".";
    private static final String OWNER_PREFIX = Owner.class.getSimpleName() + ".";

    public static void assertEquals(Customer expected, Customer actual) {
        Assert.assertEquals("Id", expected.getId(), actual.getId());
        assertEqualsStaticField(expected, actual);
    }

    public static void assertEqualsStaticField(Customer expected, Customer actual) {
        assertEqualsStoreStaticField(expected.getStore(), actual.getStore());
    }

    private static void assertEqualsOwner(Owner expected, Owner actual) {
        Assert.assertEquals(OWNER_PREFIX + "Id", expected.getId(), actual.getId());
        assertEqualsOwnerStaticField(expected, actual);
    }

    private static void assertEqualsOwnerStaticField(Owner expected, Owner actual) {
        Assert.assertEquals(OWNER_PREFIX + "FirstName", expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(OWNER_PREFIX + "LastName", expected.getLastName(), actual.getLastName());
        Assert.assertEquals(OWNER_PREFIX + "Email", expected.getEmail(), actual.getEmail());
    }

    private static void assertEqualsStore(Store expected, Store actual) {
        Assert.assertEquals(STORE_PREFIX + "Id", expected.getId(), actual.getId());
        assertEqualsStoreStaticField(expected, actual);
    }

    private static void assertEqualsStoreStaticField(Store expected, Store actual) {
        Assert.assertEquals(STORE_PREFIX + "Name", expected.getName(), actual.getName());
        Assert.assertEquals(STORE_PREFIX + "Address", expected.getAddress(), actual.getAddress());
        Assert.assertEquals(STORE_PREFIX + "Email", expected.getEmail(), actual.getEmail());
        assertEqualsOwnerStaticField(expected.getOwner(), actual.getOwner());
    }
}
