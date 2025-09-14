package com.ecommerce.productservicejuly2025.controllers;


import com.ecommerce.productservicejuly2025.commons.AuthCommons;
import com.ecommerce.productservicejuly2025.dtos.UserDto;
import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;
    private AuthCommons authCommons;

    public ProductController(@Qualifier("fakeStoreService") ProductService productService
                            , AuthCommons authCommons) {
        this.productService = productService;
        this.authCommons = authCommons;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
       return  productService.addNewProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductId(@PathVariable("id") Long id) throws ProductNotFoundException {

//        UserDto userDto = authCommons.validateToken(token);
        ResponseEntity<Product> responseEntity;
//        if(userDto == null){
//            responseEntity = new ResponseEntity<>(null ,HttpStatus.FORBIDDEN);
//            return responseEntity;
//        }

        Product product = productService.getSingleProduct(id);
        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
//                productService.getSingleProduct(id),
//                HttpStatus.OK
//        );
//  role base access wala implement karna hai
       return responseEntity ;

  }

  @GetMapping
  public ResponseEntity<List<Product>>  getAllProducts(@RequestParam("pageNumber") int pageNumber,
                                                       @RequestParam("pageSize") int pageSize){
      ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(

              productService.getAllProduct(pageNumber, pageSize),
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
