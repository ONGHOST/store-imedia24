package com.imedia24.store.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@Api(value = "Product Management", description = "Operations pertaining to products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @ApiOperation(value = "Get all products", response = List.class)
    @GetMapping("{sku}")
    public ResponseEntity<Product> getProductBySku(@PathVariable String sku) {
        Product product = productService.getProductBySku(sku);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @ApiOperation(value = "Add a product", response = Product.class)
    @PostMapping("add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }


    @ApiOperation(value = "Get a product by SKU", response = Product.class)
    @GetMapping("/getProductBySkus")
    public ResponseEntity<List<Product>> getProductsBySkus(@RequestParam List<String> skus) {
        List<Product> products = productService.getProductsBySkus(skus);
        return ResponseEntity.ok(products);
    }

    @ApiOperation(value = "Partially update a product", response = Product.class)
    @PatchMapping("update/{sku}")
    public ResponseEntity<Product> partiallyUpdateProduct(
            @PathVariable String sku,
            @RequestBody ProductUpdateRequest request) {

        Product product = productService.getProductBySku(sku);

        if (product != null) {
            if (request.name() != null) {
                product.setName(request.name());
            }

            if (request.description() != null) {
                product.setDescription(request.description());
            }

            if (request.price() != null) {
                product.setPrice(request.price());
            }

            productService.addProduct(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

