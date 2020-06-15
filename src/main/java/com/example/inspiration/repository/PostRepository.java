package com.example.inspiration.repository;

import com.example.inspiration.model.Post;
import com.example.inspiration.model.type.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
    List<Post> getAllByPostType(PostType postType);
    List<Post> getByOrderByWriteDateDesc();
}
