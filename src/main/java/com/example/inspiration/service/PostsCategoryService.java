package com.example.inspiration.service;

import com.example.inspiration.model.Post;

import java.util.List;

public interface PostsCategoryService {
    List<Post> getLatest();
    Post getOneLatestPost();
    List<Post> getPopular();
    Post getOnePopular();
}
