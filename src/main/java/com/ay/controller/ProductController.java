package com.ay.controller;

import com.ay.form.ProductForm;
import com.ay.model.Product;
import com.ay.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

//        redirectAttributes.addFlashAttribute("message", "The product was successfully added");

        return "redirect:/view-product?productId=" + product.getId();
    }

    @RequestMapping(value = "/view-product", method = RequestMethod.GET)
    public String viewProduct(@RequestParam("productId") Integer productId, Model model) {
        Product product = productService.findById(productId);

        model.addAttribute("product", product);

        return "ProductDetails";
    }

}
