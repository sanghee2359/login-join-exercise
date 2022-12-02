package com.exercise.com.controller;

import com.exercise.com.domain.dto.UserJoinRequest;
import com.exercise.com.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest // mock 테스트
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService; // userService를 MockBean

    @Autowired
    ObjectMapper objectMapper; // java Object -> json으로 만들어주는 jackson object

    @Test
    @DisplayName("회원가입 성공")
    void join() throws Exception {
        String userName = "sanghee";
        String password = "hello";

        mockMvc.perform(post("/api/v1/users/join")// post로 호출
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password)))) // httpRequest에 값을 보낼 땐 byte단위로 보낸다.
                .andDo(print())
                .andExpect(status().isOk()); // 잘 처리되면 ok
    }
    @Test
    @DisplayName("회원가입 실패 - userName 중복")
    void join_fail() throws Exception {
        String userName = "sanghee";
        String password = "hello";

        // mocking
        when(userService.join(any(),any()))
                .thenThrow(new RuntimeException("해당 userId가 중복됩니다."));

        mockMvc.perform(post("/api/v1/users/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password))))
                .andDo(print())
                .andExpect(status().isConflict());
    }

}