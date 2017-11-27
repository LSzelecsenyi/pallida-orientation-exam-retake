package com.greenfox.clothing.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "warehouse")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "item_name")
    private String itemName;
    private String manufacturer;
    private String category;
    private String size;
    @Column(name = "unit_price")
    private double unitPrice;

    public Product(String itemName, String manufacturer, String category, String size, double unitPrice) {
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.category = category;
        this.size = size;
        this.unitPrice = unitPrice;
    }

    public Product() {

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product warehouse = (Product) o;
        return Double.compare(warehouse.unitPrice, unitPrice) == 0 &&
                Objects.equals(id, warehouse.id) &&
                Objects.equals(itemName, warehouse.itemName) &&
                Objects.equals(manufacturer, warehouse.manufacturer) &&
                Objects.equals(category, warehouse.category) &&
                Objects.equals(size, warehouse.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, manufacturer, category, size, unitPrice);
    }
}
