package com.example.inspiration.service;

import com.example.inspiration.dto.PostDto;

public interface PostService {
    public void addNewPost(Long userId, PostDto form);
    public void likePost(Long postId, Long userId);
    public boolean isPostLikedByUser(Long postId, Long userId);
}
