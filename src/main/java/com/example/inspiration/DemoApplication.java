package com.example.inspiration;

import bell.oauth.discord.main.OAuthBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
public class DemoApplication {

    @Bean
    @ApplicationScope
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public OAuthBuilder oAuthBuilder() {
        OAuthBuilder builder = new OAuthBuilder("715678906987839491", "D2UczMcLKXaYB2WR6EW30aTemTKtbeIl")
                .setScopes(new String[]{"connections", "guilds", "email"})
                .setRedirectURI("http://localhost:8080/discord");
        return builder;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
