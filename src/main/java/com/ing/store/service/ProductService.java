package com.ing.store.service;

import com.ing.store.domain.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product getProductById(Integer id);

}
