package com.example.inspiration.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class HeaderService {

    public void setHrefAndName(Authentication authentication, Model model) {
        String value;
        String link;
        if (authentication == null) {
            link = "/login";
            value = "Sign In";
        } else {
            link = "/profile";
            value = "Profile";
        }
        model.addAttribute("value", value);
        model.addAttribute("link", link);
    }
}
