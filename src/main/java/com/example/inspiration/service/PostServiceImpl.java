package com.example.inspiration.service;

import com.example.inspiration.dto.PostDto;
import com.example.inspiration.model.Post;
import com.example.inspiration.model.User;
import com.example.inspiration.model.type.PostType;
import com.example.inspiration.repository.PostRepository;
import com.example.inspiration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void addNewPost(Long userId, PostDto form) {
        User user = userRepository.getOne(userId);
        Post post = Post.builder()
                .author(user)
                .content(form.getContent())
                .title(form.getTitle())
                .writeDate(LocalDateTime.now())
                .postType(PostType.valueOf(form.getPostType()))
                .build();
        postRepository.save(post);
    }

    public void likePost(Long postId, Long userId) {
        Post post = postRepository.getOne(postId);
        User user = userRepository.getOne(userId);
        Set<User> likers = post.getLikers();
        Set<Post> likedPosts = user.getLiked();
        if (isPostLikedByUser(postId, userId)) {
            likers.remove(user);
            likedPosts.remove(post);
        } else {
            likers.add(user);
            likedPosts.add(post);
        }
        user.setLiked(likedPosts);
        post.setLikers(likers);
        userRepository.save(user);
        postRepository.save(post);
    }

    public boolean isPostLikedByUser(Long postId, Long userId) {
        Post post = postRepository.getOne(postId);
        User user = userRepository.getOne(userId);
        return post.getLikers().contains(user);
    }
}
