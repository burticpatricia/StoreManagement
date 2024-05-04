package com.ing.store.service.impl;


import com.ing.store.domain.entity.Product;
import com.ing.store.repository.ProductRepository;
import com.ing.store.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultProductService implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> addProduct(Product product) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> deleteProductById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> updateProductById(Integer id, Product newProduct) {
        return Optional.empty();
    }

}
