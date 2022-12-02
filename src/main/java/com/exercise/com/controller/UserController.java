package com.exercise.com.controller;

import com.exercise.com.domain.dto.UserJoinRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping("/join")
    public String join(@RequestBody UserJoinRequest dto) {
//        return Response.success().
    }
}
