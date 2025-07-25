package com.ecommerce.productservicejuly2025.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Base {

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

    private Long id;
    private Date createAT;
    private Date updateAT;

}
