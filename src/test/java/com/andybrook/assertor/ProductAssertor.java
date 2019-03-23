package com.andybrook.assertor;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.junit.Assert;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.containsInAnyOrder;

public final class ProductAssertor {

    public static void assertEquals(Product expected, Product actual) {
        Assert.assertEquals("Id", expected.getId(), actual.getId());
        Assert.assertEquals("Name", expected.getName(), actual.getName());
        Assert.assertEquals("Price", expected.getPrice(), actual.getPrice(), 0d);
        List<BarCode> expectedBarCodeList = expected.getBarCodes()
                .stream()
                .sorted(Comparator.comparing(x -> x.getId()))
                .collect(Collectors.toList());
        List<BarCode> actualBarCodeList = actual.getBarCodes()
                .stream()
                .sorted(Comparator.comparing(x -> x.getId()))
                .collect(Collectors.toList());
        //Assert.assertThat("BarCodes", expected.getBarCodes(), containsInAnyOrder(actual.getBarCodes()));
    }
}
