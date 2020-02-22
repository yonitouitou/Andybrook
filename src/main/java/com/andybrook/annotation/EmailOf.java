package com.andybrook.annotation;

import com.andybrook.enums.DocType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface EmailOf {

    DocType value();
}
