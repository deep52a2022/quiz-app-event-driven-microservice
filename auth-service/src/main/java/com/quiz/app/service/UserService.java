package com.quiz.app.service;

import com.quiz.app.entity.UserInfo;
import com.quiz.app.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        log.info("New user added to database");
    }
    public Optional<UserInfo> getUserByName(String username){
        Optional<UserInfo> user = repository.findByName(username);
        return user;
    }



}
