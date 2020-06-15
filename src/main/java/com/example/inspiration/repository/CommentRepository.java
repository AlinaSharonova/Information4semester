package com.example.inspiration.repository;

import com.example.inspiration.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByPostId(Long postId);
}
