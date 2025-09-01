package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long ProductId) throws ProductNotFoundException;

    List<Product> getAllProduct(int pageNumber , int pageSize);

    void deleteSingleProduct(Long ProductId) throws ProductNotFoundException;

    Product updateProduct(Long id ,Product product) throws ProductNotFoundException;

    Product replaceProduct(Long id , Product product);

    Product addNewProduct(Product product);
}
