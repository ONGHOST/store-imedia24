package com.imedia24.store.product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
        List<Product> products = Collections.singletonList(
                Product.builder()
                        .id(1L)
                        .sku("12345")
                        .name("Test Product")
                        .description("Description")
                        .price(new BigDecimal("10.0"))
                        .stock(5)
                        .build()
        );
        Mockito.when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(products)));
    }

    @Test
    public void testGetProductBySku() throws Exception {
        Product product = Product.builder()
                .id(1L)
                .sku("123")
                .name("Test Product")
                .description("Description")
                .price(new BigDecimal("10.0"))
                .stock(5)
                .build();

        Mockito.when(productService.getProductBySku("12345")).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(product)));
    }


    @Test
    public void testPartiallyUpdateProduct() throws Exception {
        ProductUpdateRequest request = new ProductUpdateRequest("Updated Name", null, null);

        Product existingProduct = Product.builder()
                .id(1L)
                .sku("123")
                .name("Test Product")
                .description("Description")
                .price(new BigDecimal("10.0"))
                .stock(5)
                .build();

        Mockito.when(productService.getProductBySku("12345")).thenReturn(existingProduct);
        Mockito.when(productService.addProduct(Mockito.any())).thenReturn(existingProduct);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/products/update/123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

}
