package com.ecommerce.productservicejuly2025.controllers;


import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductId(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);

  }

  @GetMapping
  public List<Product> getAllProducts(){
    return productService.getAllProduct() ;
  }


}
