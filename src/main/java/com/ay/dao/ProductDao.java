package com.ay.dao;

import com.ay.param.ProductListParam;
import com.ay.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Integer id);

    int saveProduct(Product product);

    List<Product> listProduct(ProductListParam productListForm);

    int updateProduct(Product product);

    int deleteProduct(Integer productId);
}
