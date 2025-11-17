package com.fahami.cda.entity;

import com.fahami.cda.entity.enumeration.Category;
import java.util.Objects;

public class Product {
    // Les propriétés
    private String name;
    private Category category; // catégorie du produit de type enum
    private boolean isOutOfStock;
    private Double price;

    
    // Les constructeurs
    public Product(String name, Category category){
        this.name = name;
        this.category = category;
        this.isOutOfStock = false;
    }

    public Product(){
        this.isOutOfStock = false;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", category='" + getCategory() + "'" +
            ", isOutOfStock='" + isIsOutOfStock() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    // Les getters et settters
   public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isIsOutOfStock() {
        return this.isOutOfStock;
    }

    public boolean getIsOutOfStock() {
        return this.isOutOfStock;
    }

    public void setIsOutOfStock(boolean isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category) && isOutOfStock == product.isOutOfStock && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, isOutOfStock, price);
    }
}
