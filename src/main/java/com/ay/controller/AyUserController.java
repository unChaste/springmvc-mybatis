package com.ay.controller;

import com.ay.model.AyUser;
import com.ay.model.Book;
import com.ay.model.User;
import com.ay.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AyUserController {
    @Autowired
    private AyUserService ayUserService;

    @GetMapping("/user/findAll")
    public String findAll(Model model) {
        List<AyUser> ayUserList = ayUserService.findAll();
        for (AyUser ayUser : ayUserList) {
            System.out.println("id: " + ayUser.getId() + "/name: " + ayUser.getName());
        }
        return "hello";
    }
}
