package com.ecommerce.productservicejuly2025.controllers;


import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.services.ProductService;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
     return productService.replaceProduct(id, product);
  }
    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return   productService.updateProduct(id, product);
    }


}
