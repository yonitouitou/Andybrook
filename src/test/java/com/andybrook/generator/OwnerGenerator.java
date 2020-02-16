package com.andybrook.generator;

import com.andybrook.model.customer.Owner;
import com.andybrook.util.clock.Clock;

public final class OwnerGenerator {

    public static Owner generateOwner() {
        long now = Clock.nanos();
        return new Owner("Compagny_" + now, "John_" + now, "Durant_" + now, "john.durant_" + now + "@gmail.com");
    }
}
