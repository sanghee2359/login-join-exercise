package com.exercise.com.service;

import com.exercise.com.configuration.EncoderConfig;
import com.exercise.com.domain.User;
import com.exercise.com.exception.AppException;
import com.exercise.com.exception.ErrorCode;
import com.exercise.com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder; // encoder로 인코딩
    public String join(String userName, String password) {

        // userName의 중복 check
        userRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPLICATED, userName + "는 이미 존재하는 이름입니다."); // error가 나면 여기서 에러가 발생
                });
        User user = User.builder()
                .userName(userName)
                .password(encoder.encode(password))
                .build();
        userRepository.save(user);

        return "SUCCESS";
    }
}
