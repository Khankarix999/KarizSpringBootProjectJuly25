package com.ecommerce.productservicejuly2025.models;

import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

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
}
