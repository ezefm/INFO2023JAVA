package com.ezefm.informatorio2023.board.escenario2.entity;

import java.util.List;

public class Category {
    private String name;
    private String description;
    private Boolean available;
    private List<Product> productList;
    public Category(){}
    public Category(String name, String description, Boolean available, List<Product> productList) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.productList = productList;
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
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}