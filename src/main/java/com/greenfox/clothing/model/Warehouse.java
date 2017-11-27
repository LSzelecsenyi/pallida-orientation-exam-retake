package com.greenfox.clothing.model;

import javax.persistence.*;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String itemName;
    private String manufacturer;
    private String category;
    private String size;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "in_store")
    private boolean inStore;

    public Warehouse() {
    }

    public Warehouse(String itemName, String manufacturer, String category, String size, double unitPrice, boolean inStore) {
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.category = category;
        this.size = size;
        this.unitPrice = unitPrice;
        this.inStore = inStore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }
}
