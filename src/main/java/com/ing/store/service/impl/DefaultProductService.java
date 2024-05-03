package com.ing.store.service.impl;


import com.ing.store.domain.entity.Product;
import com.ing.store.repository.ProductRepository;
import com.ing.store.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultProductService implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
