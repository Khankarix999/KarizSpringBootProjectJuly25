package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.dtos.FakeStoreProductDto;
import com.ecommerce.productservicejuly2025.models.Category;
import com.ecommerce.productservicejuly2025.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long ProductId) {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + ProductId,
                FakeStoreProductDto.class);
        // Convert fakestoredto product to my Product

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setCategory(new Category(fakeStoreProductDto.getCategory(),
                fakeStoreProductDto.getDescription()));
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }
}
