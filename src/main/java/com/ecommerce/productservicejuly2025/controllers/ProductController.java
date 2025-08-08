package com.ecommerce.productservicejuly2025.controllers;


import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("dbProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
       return  productService.addNewProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductId(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return responseEntity ;

  }

  @GetMapping
  public ResponseEntity<List<Product>>  getAllProducts(){
      ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(
              productService.getAllProduct(),
              HttpStatus.OK
      );

        return responseEntity;
  }

  @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
     return productService.replaceProduct(id, product);
  }
    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return   productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteproduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        productService.deleteSingleProduct(id);
    }


}
