package com.ay.service;

import com.ay.form.ProductListParam;
import com.ay.model.Product;
import com.github.pagehelper.PageInfo;

public interface ProductService {
    Product findById(Integer id);

    int saveProduct(Product product);

    PageInfo<Product> listProduct(ProductListParam productListForm);

    int updateProduct(Product product);

    int deleteProduct(String productId);
}
