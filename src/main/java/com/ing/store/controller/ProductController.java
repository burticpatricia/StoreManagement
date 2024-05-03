package com.ing.store.controller;

import com.ing.store.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openapitools.api.ProductsApiDelegate;
import org.openapitools.model.ProductDto;
import org.openapitools.model.ProductTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController implements ProductsApiDelegate {

    @Autowired
    ProductService productService;

    @Override
    public ProductDto getProductById(Integer productId) {
        return new ProductDto(productId, "hello", 3.3d, ProductTypeDto.FOOD, 45);
    }
}
