package com.example.inspiration.сontroller;

import com.example.inspiration.dto.PostDto;
import com.example.inspiration.model.User;
import com.example.inspiration.service.PostService;
import com.example.inspiration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newPost")
public class PostCreatorController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping
    public String getPage(Authentication authentication, Model model) {
        User user = userService.getUser(authentication);
        model.addAttribute("user", user);
        return "postcreator";
    }

    @PostMapping
    public String afterCreate(Authentication authentication, PostDto form) {
        User user = userService.getUser(authentication);
        postService.addNewPost(user.getId(), form);
        return "redirect:/profile";
    }
}
