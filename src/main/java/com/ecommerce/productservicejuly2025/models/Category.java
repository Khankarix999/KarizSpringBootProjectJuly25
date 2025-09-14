package com.ecommerce.productservicejuly2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends Base{

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String description;


    public Category(String name , String description) {
        this.name = name;
        this.description = description;
    }
    protected Category() {
    }
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
