package com.ing.store.service;

import com.ing.store.domain.entity.Product;
import com.ing.store.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Integer id);

    Optional<Product> addProduct(Product product);

    Product deleteProductById(Integer id) throws EntityNotFoundException;

    List<Product> getAllProducts();

    Optional<Product> updateProductById(Integer id, Product newProduct);

}
