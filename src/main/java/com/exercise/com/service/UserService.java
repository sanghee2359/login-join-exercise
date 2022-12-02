package com.exercise.com.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public String join(String userName, String password) {

        // userName의 중복 checki


        return "SUCCESS";
    }
}
