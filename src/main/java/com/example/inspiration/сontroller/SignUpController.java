package com.example.inspiration.сontroller;

import com.example.inspiration.dto.SignUpDto;
import com.example.inspiration.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @GetMapping
    public String signUpPage(Model model) {
        return "register";
    }

    @PostMapping
    public String signUp(SignUpDto signUpDto, Model model) {
        if (signUpService.signUp(signUpDto)) {
            return "/login";
        } else {
            model.addAttribute("serverError", "Invalid registration data!");
            return "register";
        }
    }
}
