package com.ezefm.informatorio2023.board.escenario2.entity;

import java.util.UUID;
public class Product {
    private String id = String.valueOf(UUID.randomUUID());
    private String name;
    private String description;
    private String category;
    /*
    Discount: percentage calculated from the current price (Online)
    and the crossed out price(price before the discount)
    */
    private CrossedOutPrice crossedOutPrice;
    private Double discount;
    private Price actualPrice;

    public Product(){}

    public Product(String name, String description, String category, Price actualPrice, CrossedOutPrice crossedOutPrice) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.actualPrice = actualPrice;
        this.crossedOutPrice = crossedOutPrice;
        if(crossedOutPrice.getValue() > 0){
            this.discount = (this.crossedOutPrice.getValue() - this.actualPrice.getValue()) * 100 / this.crossedOutPrice.getValue();
        } else {
            this.discount = 0.0;
        }
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public CrossedOutPrice getCrossedOutPrice() {
        return crossedOutPrice;
    }
    public void setCrossedOutPrice(CrossedOutPrice crossedOutPrice) {
        this.crossedOutPrice = crossedOutPrice;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public Price getActualPrice() {
        return actualPrice;
    }
    public void setActualPrice(Price actualPrice) {
        this.actualPrice = actualPrice;
    }
}