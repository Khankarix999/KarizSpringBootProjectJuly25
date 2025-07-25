package com.ecommerce.productservicejuly2025.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base{
    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }



    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private Double price;
    private Category category;
}
