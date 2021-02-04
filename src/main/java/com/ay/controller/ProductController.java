package com.ay.controller;

import com.ay.form.ProductForm;
import com.ay.form.ProductListParam;
import com.ay.model.Product;
import com.ay.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/input-product", method = RequestMethod.GET)
    public String inputProduct() {
        return "ProductForm";
    }

    @RequestMapping(value = "/save-product", method = RequestMethod.POST)
    public String saveProduct(ProductForm productForm) {
        logger.info("saveProduct方法被调用");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            Double price = Double.parseDouble(productForm.getPrice());
            product.setPrice(price);
        } catch (NumberFormatException e) {
            logger.error("价格格式错误");
        }

        productService.saveProduct(product);

        return "redirect:/view-product?productId=" + product.getId();
    }

    @RequestMapping(value = "view-product", method = RequestMethod.GET)
    public String viewProduct(@RequestParam("productId") Integer productId, Model model) {
        Product product = productService.findById(productId);

        model.addAttribute("product", product);

        return "ProductDetails";
    }

    @RequestMapping(value = "/list-product", method = RequestMethod.GET)
    public String listProduct(ProductListParam productListParam, Model model) {
        PageInfo<Product> pageInfo = productService.listProduct(productListParam);

        model.addAttribute("pageInfo", pageInfo);

        return "ProductList";
    }

    @GetMapping("/edit-product")
    public String editProduct(Integer productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "ProductEdit";
    }

    @PostMapping("/update-product")
    public String updateProduct(Product product) {
        productService.updateProduct(product);

        return "redirect:/list-product";
    }

    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam("productId") String productId) {
        productService.deleteProduct(productId);

        return "redirect:/list-product";
    }

}
