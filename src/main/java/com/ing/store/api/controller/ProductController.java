package com.ing.store.api.controller;

import com.ing.store.api.mapper.ProductMapper;
import com.ing.store.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openapitools.api.ProductsApiDelegate;
import org.openapitools.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProductById(Integer productId) {
        return null;
    }

    @Override
    public ProductDto updateProductById(Integer productId, ProductDto productDto) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return null;
    }

}
