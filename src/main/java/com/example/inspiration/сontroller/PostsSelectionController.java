package com.example.inspiration.сontroller;

import com.example.inspiration.model.Post;
import com.example.inspiration.model.type.PostType;
import com.example.inspiration.repository.PostRepository;
import com.example.inspiration.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostsSelectionController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    HeaderService headerService;

    @GetMapping("/posts/{selection}")
    public String getPosts(@PathVariable String selection, Model model, Authentication authentication) {
        List<Post> posts;
        model.addAttribute("selection", selection);
        posts = postRepository.getAllByPostType(PostType.valueOf(selection.toUpperCase()));
        model.addAttribute("posts", posts);
        headerService.setHrefAndName(authentication, model);
        return "postspage";
    }
}
