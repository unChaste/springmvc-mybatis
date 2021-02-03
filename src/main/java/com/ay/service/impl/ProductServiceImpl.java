package com.ay.service.impl;

import com.ay.dao.ProductDao;
import com.ay.model.Product;
import com.ay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public int saveProduct(Product product) {
        int result = productDao.saveProduct(product);
        return result;
    }
}
