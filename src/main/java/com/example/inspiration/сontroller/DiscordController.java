package com.example.inspiration.сontroller;

import bell.oauth.discord.main.OAuthBuilder;
import com.example.inspiration.model.User;
import com.example.inspiration.security.details.UserDetailsImpl;
import com.example.inspiration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class DiscordController {

    @Autowired
    OAuthBuilder builder;

    @Autowired
    UserService userService;


    @GetMapping("/discord")
    public ModelAndView getDiscordAuth(@RequestParam("code") String code) {
        builder.exchange(code);
        Optional<User> user = userService.getUserByEmail(builder.getUser().getEmail());
        if (!user.isPresent()) {
            return new ModelAndView("redirect:login");
        } else {
            UserDetailsImpl userDetails = new UserDetailsImpl(user.get());
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(userDetails, user.get().getHashedPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
            return new ModelAndView("redirect:profile");
        }
    }
}
