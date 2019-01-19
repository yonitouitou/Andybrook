package com.andybrook.annotation;

import com.andybrook.enums.ProductType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface StockItemEntityConverterByProductType {

    ProductType type();
}
