package com.example.inspiration.сontroller;

import com.example.inspiration.dto.CommentDto;
import com.example.inspiration.model.Comment;
import com.example.inspiration.model.Post;
import com.example.inspiration.repository.CommentRepository;
import com.example.inspiration.repository.PostRepository;
import com.example.inspiration.service.HeaderService;
import com.example.inspiration.service.PostService;
import com.example.inspiration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;

    @Autowired
    HeaderService headerService;

    @Autowired
    PostService postService;

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Authentication authentication, Model model) {
        Post post = postRepository.findById(id).get();
        model.addAttribute("post", post);
        model.addAttribute("auth", authentication);
        model.addAttribute("comments", commentRepository.getCommentsByPostId(post.getId()));
        headerService.setHrefAndName(authentication, model);
        return "post";
    }

    @GetMapping("/post/{id}/like")
    public String likePost(@PathVariable Long id, Authentication authentication, Model model) {
        Post post = postRepository.findById(id).get();
        postService.likePost(id, userService.getUser(authentication).getId());
        model.addAttribute("post", post);
        model.addAttribute("auth", authentication);
        model.addAttribute("comments", commentRepository.getCommentsByPostId(post.getId()));
        headerService.setHrefAndName(authentication, model);
        return "post";
    }

    @PostMapping("/post/{id}")
    public String sendComment(@PathVariable Long id, Authentication authentication, Model model, CommentDto commentDto) {
        commentRepository.save(Comment.builder()
                .content(commentDto.getContent())
                .user(userService.getUser(authentication))
                .post(postRepository.getOne(id))
                .build());
        return getPost(id, authentication, model);
    }
}
