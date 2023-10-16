package com.imedia24.store.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySku(String sku);

    List<Product> findAll();

    List<Product> findBySkuIn(List<String> skus);


}

