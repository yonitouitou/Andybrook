package com.andybrook.enums;

import org.springframework.util.Assert;

public enum ProductType {
    GLASSES("GL");


    private String symbol;

    ProductType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static ProductType getBySymbol(String symbol) {
        Assert.notNull(symbol, "The symbol cannot be null");
        ProductType type;
        switch (symbol) {
            case "GL":
            default:
                type = ProductType.GLASSES;
                break;
        }
        return type;
    }
}
