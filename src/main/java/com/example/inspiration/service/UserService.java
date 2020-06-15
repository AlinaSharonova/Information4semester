package com.example.inspiration.service;

import com.example.inspiration.model.User;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface UserService {
    User getUser(Authentication authentication);
    Optional<User> getUserByEmail(String email);
}
