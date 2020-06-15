package com.example.inspiration.service;

import com.example.inspiration.dto.SignUpDto;
import com.example.inspiration.model.User;
import com.example.inspiration.model.type.Role;
import com.example.inspiration.model.type.State;
import com.example.inspiration.repository.UserRepository;
import com.example.inspiration.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(SignUpDto signUpDto) {
        if (isExist(signUpDto.getEmail(), signUpDto.getNickName())) {
            return false;
        }
        if (signUpDto.getPassword().length() < 8) {
            return false;
        }
        if (!signUpDto.getPassword().equals(signUpDto.getRepeatPassword())) {
            return false;
        }
        if (!(new EmailValidator()).validate(signUpDto.getEmail())) {
            return false;
        }
        User user = User.builder()
                .email(signUpDto.getEmail())
                .nickName(signUpDto.getNickName())
                .avatarPath("C:\\Users\\Алина\\IdeaProjects\\blog2v\\src\\main\\resources\\static\\document\\img\\apv1.jpg")
                .regdate(new Date())
                .hashedPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .role(Role.ORD_USER)
                .state(State.CONFIRMED)
                .build();
        userRepository.save(user);
        return true;
    }

    private boolean isExist(String email, String nickName) {
        return userRepository.findUserByEmail(email).isPresent()
                || userRepository.findUserByNickName(nickName).isPresent();
    }
}
