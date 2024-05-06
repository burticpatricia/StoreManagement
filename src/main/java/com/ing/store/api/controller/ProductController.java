package com.ing.store.api.controller;

import com.ing.store.api.mapper.ProductMapper;
import com.ing.store.exception.EntityNotFoundException;
import com.ing.store.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.ProductsApiDelegate;
import org.openapitools.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
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
        log.info("Get product with id: " + productId);
        return mapper.dtoFromProduct(service.getProductById(productId).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        log.info("Add new product.");
        return mapper.dtoFromProduct(
                service.addProduct(
                        mapper.productFromDto(productDto)
                ).orElseThrow()
        );
    }

    @Override
    public ProductDto deleteProductById(Integer productId) {
        log.info("Delete product with id: " + productId);
        return mapper.dtoFromProduct(service.deleteProductById(productId));
    }

    @Override
    public ProductDto updateProductById(Integer productId, ProductDto productDto) {
        log.info("Update product with id: " + productId);
        return mapper.dtoFromProduct(
                service.updateProductById(productId, mapper.productFromDto(productDto)).orElseThrow()
        );
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.info("Get all products");
        return mapper.dtoListFromProductList(service.getAllProducts());
    }
}
