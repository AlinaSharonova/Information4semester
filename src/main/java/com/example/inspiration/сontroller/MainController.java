package com.example.inspiration.сontroller;

import com.example.inspiration.repository.PostRepository;
import com.example.inspiration.service.HeaderService;
import com.example.inspiration.service.PostsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    HeaderService headerService;

    @Autowired
    PostsCategoryService postsCategoryService;

    @Autowired
    PostRepository postRepository;

    @GetMapping()
    public String page(Authentication authentication, Model model) {
        headerService.setHrefAndName(authentication, model);
        model.addAttribute("popularPost", postsCategoryService.getOnePopular());
        model.addAttribute("latestPost", postsCategoryService.getOneLatestPost());
        return "mainpage";
    }
}
