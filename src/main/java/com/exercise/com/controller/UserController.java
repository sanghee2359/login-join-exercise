package com.exercise.com.controller;

import com.exercise.com.domain.dto.UserJoinRequest;
import com.exercise.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinRequest dto) {
        userService.join(dto.getUserName(),dto.getPassword());
        return ResponseEntity.ok().body("회원가입이 성공했습니다.");
    }
}
