package com.exercise.com.service;

import com.exercise.com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String join(String userName, String password) {

        // userName의 중복 check
        userRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new RuntimeException(userName + "는 이미 존재하는 이름입니다.");
                });

        return "SUCCESS";
    }
}
