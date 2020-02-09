package com.andybrook.assertor;

import com.andybrook.model.BarCode;
import org.junit.Assert;

public final class BarCodeAssertor {

    public static void assertEquals(BarCode expected, BarCode actual) {
        Assert.assertEquals(expected.get(), actual.get());
    }

}
