package com.ay.service.impl;

import com.ay.dao.ProductDao;
import com.ay.form.ProductListParam;
import com.ay.model.Product;
import com.ay.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer id) {
        Product product = productDao.findById(id);
        return product;
    }

    @Override
    public int saveProduct(Product product) {
        int result = productDao.saveProduct(product);
        return result;
    }

    @Override
    public PageInfo<Product> listProduct(ProductListParam productListParam) {
        PageHelper.startPage(productListParam.getPageNum(), productListParam.getPageSize());
        List<Product> productList = productDao.listProduct(productListParam);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);

        return pageInfo;
    }

    @Override
    public int updateProduct(Product product) {
        int result = productDao.updateProduct(product);
        return result;
    }

    @Override
    public int deleteProduct(String productId) {
        int result = productDao.deleteProduct(productId);
        return result;
    }
}
