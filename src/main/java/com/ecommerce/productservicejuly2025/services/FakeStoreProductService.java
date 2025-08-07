package com.ecommerce.productservicejuly2025.services;

import com.ecommerce.productservicejuly2025.dtos.FakeStoreProductDto;
import com.ecommerce.productservicejuly2025.exceptions.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Category;
import com.ecommerce.productservicejuly2025.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long ProductId) throws ProductNotFoundException {

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + ProductId,
                FakeStoreProductDto.class);
        // Convert fakestoredto product to my Product

        if(fakeStoreProductDto == null){
             throw new ProductNotFoundException("Product with id " + ProductId +" does not exist");
        }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
//        product.setCategory(new Category(fakeStoreProductDto.getCategory(),
//                fakeStoreProductDto.getDescription()));
//            product.setTitle(fakeStoreProductDto.getTitle());
//            product.setPrice(fakeStoreProductDto.getPrice());

        return product;
    }

    @Override
    public List<Product> getAllProduct() {

        FakeStoreProductDto[] fakeStoreProductDtos =
        restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        //in the above code theres a problem wid generic class thats why we cant use List<FakestoreProductDto> please
        //revice that part
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public void deleteSingleProduct(Long ProductId) {

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        //PATCH
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class , restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto= restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH ,
                requestCallback ,
                responseExtractor
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    //My code
    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class , restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto= restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT ,
                requestCallback ,
                responseExtractor
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }


}
