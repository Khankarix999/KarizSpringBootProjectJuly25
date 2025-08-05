package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;

import java.util.List;

public class DbProductService implements ProductService {
    @Override
    public Product getSingleProduct(Long ProductId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }


}
