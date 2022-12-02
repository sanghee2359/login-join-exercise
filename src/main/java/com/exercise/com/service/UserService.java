package com.exercise.com.service;

import com.exercise.com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String join(String userName, String password) {

        // userName의 중복 checki


        return "SUCCESS";
    }
}
