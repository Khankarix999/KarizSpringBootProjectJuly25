package com.ecommerce.productservicejuly2025.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Base implements Serializable {

    public Long getId() {
        return id;
    }

    public Date getUpdateAT() {
        return updateAT;
    }

    public Date getCreateAT() {
        return createAT;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpdateAT(Date updateAT) {
        this.updateAT = updateAT;
    }

    public void setCreateAT(Date createAT) {
        this.createAT = createAT;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increament
    private Long id;
    private Date createAT;
    private Date updateAT;

}
