package com.ing.store.api.controller;

import com.ing.store.api.mapper.ProductMapper;
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
    ProductService service;

    @Autowired
    ProductMapper mapper;

    @Override
    public ProductDto getProductById(Integer productId) {
        return mapper.dtoFromProduct(service.getProductById(productId).orElseThrow());
    }
}
