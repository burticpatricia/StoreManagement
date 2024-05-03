package com.ing.store.controller;

import org.openapitools.api.ProductsApiDelegate;
import org.openapitools.model.ProductDto;
import org.openapitools.model.ProductTypeDto;
import org.springframework.stereotype.Component;

@Component
public class ProductController implements ProductsApiDelegate {
    @Override
    public ProductDto getProductById(Long productId) {
        return new ProductDto(2, "hello", 3.3d, ProductTypeDto.FOOD, 45);
    }
}
