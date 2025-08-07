package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class DbProductService implements ProductService {

    ProductRepository productRepository;

    public DbProductService(ProductRepository productReposiitory){
        this.productRepository = productReposiitory;
    }


    @Override
    public Product getSingleProduct(Long ProductId) throws ProductNotFoundException {
       Optional<Product> optionalProduct = productRepository.findById(ProductId); // optional product because product cud be null and when gettitle will be used itll throw not found exception

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+ ProductId + "does not exist"  );
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();

    }

    @Override
    public void deleteSingleProduct(Long ProductId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(ProductId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+ ProductId + "does not exist"  );
        }
        productRepository.deleteById(ProductId);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+ id + "does not exist"  );
        }

        Product productInDb = optionalProduct.get();

        if(product.getTitle() != null){
            productInDb.setTitle(product.getTitle());
        }

        if(product.getPrice() != null){
            productInDb.setPrice(product.getPrice());
        }
        return productRepository.save(productInDb);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }


}
