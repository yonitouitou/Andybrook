package com.andybrook.model.product;

import com.andybrook.model.BarCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ProductInfo {

    protected int quantityCreated;
    protected int quantityUsed;
    protected Map<String, BarCode> barCodes;

    public Optional<BarCode> getFreeBarCode() {
        return barCodes.values()
                .stream()
                .filter(barCode -> ! barCode.isUsed())
                .findFirst();
    }

    public void incrementQuantityCreated(int qtyToIncrement) {
        quantityCreated += qtyToIncrement;
    }

    public void decrementQuantityCreated(int qtyToDecrement) {
        quantityCreated -= qtyToDecrement;
    }

    public void incrementQuantityUsed() {
        incrementQuantityUsed(1);
    }

    public void incrementQuantityUsed(int qtyToIncrement) {
        quantityUsed += qtyToIncrement;
    }

    public void decrementQuantityUsed() {
        decrementQuantityUsed(1);
    }

    public void decrementQuantityUsed(int qtyToDecrement) {
        quantityUsed -= qtyToDecrement;
    }

    public void addBarCode(BarCode barCode) {
        barCodes.put(barCode.getId(), barCode);
        incrementQuantityCreated(1);
    }

    public void deleteBarCode(String barCodeId) {
        barCodes.remove(barCodeId);
        decrementQuantityCreated(1);
    }

    public Map<String, BarCode> getBarCodes() {
        return new HashMap<>(barCodes);
    }

    public void setBarCodes(Map<String, BarCode> barCodes) {
        this.barCodes = barCodes;
        quantityCreated = barCodes.size();
    }

    public int getQuantityCreated() {
        return quantityCreated;
    }

    public void setQuantityCreated(int quantityCreated) {
        this.quantityCreated = quantityCreated;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public int getQuantityUnused() {
        return quantityCreated - quantityUsed;
    }
}
