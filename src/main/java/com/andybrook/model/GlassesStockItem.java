package com.andybrook.model;

public class GlassesStockItem {

    private Long id;
    private Glasses glasses;
    private double quantity;

    public GlassesStockItem(Glasses glasses, double quantity) {
        this.glasses = glasses;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Glasses getGlasses() {
        return glasses;
    }

    public void setGlasses(Glasses glasses) {
        this.glasses = glasses;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return glasses.getPrice() * quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GlassesStockItem{");
        sb.append("id=").append(id);
        sb.append(", glasses=").append(glasses);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
