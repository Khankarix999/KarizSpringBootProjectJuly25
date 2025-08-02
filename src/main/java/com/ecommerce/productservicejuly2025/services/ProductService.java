package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long ProductId) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product updateProduct(Long id ,Product product);

    Product replaceProduct(Long id , Product product);
}
