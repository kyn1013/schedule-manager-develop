package com.example.scheduledevelop.auth.controller;

import com.example.scheduledevelop.auth.dto.SignupRequestDto;
import com.example.scheduledevelop.auth.dto.SignupResponseDto;
import com.example.scheduledevelop.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signUp(@RequestBody SignupRequestDto requestDto){
        SignupResponseDto signupResponseDto = authService.signUp(requestDto);
        return new ResponseEntity<>(signupResponseDto, HttpStatus.CREATED);
    }

}
