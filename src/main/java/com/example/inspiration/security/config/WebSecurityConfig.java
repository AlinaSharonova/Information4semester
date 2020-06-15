package com.example.inspiration.security.config;

import com.example.inspiration.model.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier(value = "ownUserDetailsService") //чтобы нашёл конкретный кастомный бин в UserDetailsServiceImpl
    private UserDetailsService userDetailsService;

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/register").permitAll();
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/profile","/logout").authenticated()
                .antMatchers("/login").anonymous()
                .antMatchers("/becomeAuthor").hasAuthority(Role.ORD_USER.name())
                .antMatchers("/newPost").hasAnyAuthority(Role.ADMIN.name(), Role.AUTHOR.name(), Role.EDITOR.name());
        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password");
    }
}
