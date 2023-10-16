package com.imedia24.store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private Faker faker;

    public Product generateFakeProduct() {
        Product product = new Product();
        product.setSku(faker.number().digits(6));
        product.setName(faker.commerce().productName());
        product.setDescription(faker.lorem().sentence());
        double randomPrice = faker.number().randomDouble(2, 10, 1000);
        product.setPrice(BigDecimal.valueOf(randomPrice));
        return product;
    }
    @Autowired
    private ProductRepository productRepository;

    public Product getProductBySku(String sku) {

        return productRepository.findBySku(sku);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }


    public List<Product> getProductsBySkus(List<String> skus) {
        return productRepository.findBySkuIn(skus);
    }


}

