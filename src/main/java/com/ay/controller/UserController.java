package com.ay.controller;

import com.ay.model.Book;
import com.ay.model.User;
import com.ay.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/main";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入!");
            return "redirect:/loginForm";
        }
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("疯狂Java讲义", "李刚", 74.2));
        bookList.add(new Book("疯狂Android讲义", "李刚", 74.2));
        bookList.add(new Book("轻量级Java EE 企业应用实战", "李刚", 74.2));
        model.addAttribute("bookList", bookList);
        return "main";
    }
}
