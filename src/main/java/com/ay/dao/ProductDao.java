package com.ay.dao;

import com.ay.model.Product;

public interface ProductDao {
    Product findById(Integer id);

    int saveProduct(Product product);
}
