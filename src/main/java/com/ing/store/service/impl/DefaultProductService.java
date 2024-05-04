package com.ing.store.service.impl;


import com.ing.store.domain.entity.Product;
import com.ing.store.exception.EntityNotFoundException;
import com.ing.store.repository.ProductRepository;
import com.ing.store.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
        return Optional.of(productRepository.save(product));
    }

    @Override
    public Product deleteProductById(Integer id) throws EntityNotFoundException {
        val maybeProductToBeDeleted = productRepository.findById(id);
        maybeProductToBeDeleted.ifPresentOrElse(
                (productToBeDeleted) -> {
                    log.debug("Found product with id: " + id + ". Will delete it");
                    productRepository.delete(productToBeDeleted);
                    log.debug("Product with id: " + id + " was deleted.");
                },
                () -> {
                    log.error("Did not find product with id: " + id);
                    throw new EntityNotFoundException(Product.class.getName(), id);
                }
        );
        return maybeProductToBeDeleted.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> updateProductById(Integer id, Product newProduct) {
        newProduct.setId(id);
        return Optional.of(productRepository.save(newProduct));
    }

}
