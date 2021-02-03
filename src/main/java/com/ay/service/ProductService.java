package com.ay.service;

import com.ay.model.Product;

public interface ProductService {
    Product findById(Integer id);

    int saveProduct(Product product);
}
