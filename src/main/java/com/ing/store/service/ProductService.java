package com.ing.store.service;

import com.ing.store.domain.entity.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Integer id);

}
