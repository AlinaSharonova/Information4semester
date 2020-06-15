package com.example.inspiration.сontroller;

import com.example.inspiration.model.User;
import com.example.inspiration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@RequestMapping("/profile")
@SessionScope
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping
    public String page(Authentication authentication, Model model) {
        User user = userService.getUser(authentication);
        model.addAttribute("user", user);
        return "profile";
    }
}
