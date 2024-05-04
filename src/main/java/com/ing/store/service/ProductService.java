package com.ing.store.service;

import com.ing.store.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Integer id);

    Optional<Product> addProduct(Product product);

    Optional<Product> deleteProductById(Integer id);

    List<Product> getAllProducts();

    Optional<Product> updateProductById(Integer id, Product newProduct);

}
