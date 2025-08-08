package com.ecommerce.productservicejuly2025;

import com.ecommerce.productservicejuly2025.projections.ProductWithIdAndTitle;
import com.ecommerce.productservicejuly2025.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceJuly2025ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDbQueries(){
        List<ProductWithIdAndTitle> productWithIdAndTitle
                = productRepository.randomSearchMethodForProduct();

        for(ProductWithIdAndTitle product : productWithIdAndTitle){
            System.out.println(product.getId() + " " + product.getTitle());
        }

        List<ProductWithIdAndTitle> productWithIdAndTitleFromNative
                = productRepository.nativeSearchMethodForProduct();

        for(ProductWithIdAndTitle product : productWithIdAndTitleFromNative){
            System.out.println(product.getId() + " " + product.getTitle());
        }

        System.out.println("Deubg");
    }
}
