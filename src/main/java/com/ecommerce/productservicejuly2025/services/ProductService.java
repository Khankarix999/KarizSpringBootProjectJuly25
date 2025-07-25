package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long ProductId);

    List<Product> getAllProduct();

}
