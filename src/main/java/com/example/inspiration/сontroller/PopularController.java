package com.example.inspiration.сontroller;

import com.example.inspiration.service.HeaderService;
import com.example.inspiration.service.PostsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popular")
public class PopularController {

    @Autowired
    PostsCategoryService postsCategoryService;

    @Autowired
    HeaderService headerService;

    @GetMapping
    public String getPopular(Authentication authentication, Model model) {
        model.addAttribute("selection", "popular");
        model.addAttribute("posts", postsCategoryService.getPopular());
        headerService.setHrefAndName(authentication, model);
        return "postspage";
    }
}
