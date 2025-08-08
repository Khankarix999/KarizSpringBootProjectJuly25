package com.ecommerce.productservicejuly2025.repositories;

import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product ,Long > {

    // Product Repo should contain  all methods (CRUD) related to Product

    // select * from  Product where price >
    List<Product> findProductByPriceGreaterThan(Double price);

    //select * from Product where title like "%iphone%"

    List<Product> findProductByTitleLike(String title);

    //select * from Product where title like 'iphone' LIMIT 5

    //List<Product> findProductByTitleLike(int top , String title);

    List<Product> findByPriceBetween(Double p1, Double p2);


    Optional<Product> findById(Long aLong);

    @Query("select p.id as id, p.title as title from Product p")
    List<ProductWithIdAndTitle> randomSearchMethodForProduct();

    // Native query
    @Query(nativeQuery = true , value="select p.id as id , p.title as title from product p")
    List<ProductWithIdAndTitle> nativeSearchMethodForProduct();
}
