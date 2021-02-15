package com.ay.controller;

import com.ay.param.SaveUserRequest;
import com.ay.model.Product;
import com.ay.service.ProductService;
import com.ay.validator.DateEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/userForm")
    private String userForm() {
        Product product = productService.findById(1);
        System.out.println(product);

        return "test/userForm";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid SaveUserRequest userRequest, Model model, Errors errors) {
        int a = 5 / 0;
        System.out.println(errors.getAllErrors());
        System.out.println(userRequest);
        model.addAttribute("user", userRequest);
        return "test/viewUser";
    }

    //    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
