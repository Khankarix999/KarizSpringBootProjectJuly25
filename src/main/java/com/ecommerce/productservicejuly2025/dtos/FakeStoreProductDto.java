package com.ecommerce.productservicejuly2025.dtos;





public class FakeStoreProductDto {


    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
