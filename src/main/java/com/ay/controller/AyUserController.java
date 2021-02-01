package com.ay.controller;

import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class AyUserController {
    @Autowired
    private AyUserService ayUserService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<AyUser> ayUserList = ayUserService.findAll();
        for (AyUser ayUser : ayUserList) {
            System.out.println("id: " + ayUser.getId() + "/name: " + ayUser.getName());
        }
        return "hello";
    }
}
