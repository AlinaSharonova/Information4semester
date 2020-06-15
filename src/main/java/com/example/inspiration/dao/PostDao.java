package com.example.inspiration.dao;

import com.example.inspiration.model.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDao {
    List<Post> getPopular() throws SQLException, ClassNotFoundException;
}
