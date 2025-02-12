package com.example.scheduledevelop.auth.service;

import com.example.scheduledevelop.auth.dto.LoginRequestDto;
import com.example.scheduledevelop.auth.dto.LoginResponseDto;
import com.example.scheduledevelop.auth.dto.SignupRequestDto;
import com.example.scheduledevelop.auth.dto.SignupResponseDto;
import com.example.scheduledevelop.core.common.exception.InvalidPasswordException;
import com.example.scheduledevelop.core.common.exception.MemberNotFoundException;
import com.example.scheduledevelop.core.config.PasswordEncoder;
import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponseDto signUp(SignupRequestDto requestDto) {
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        Member member = Member.builder()
                        .name(requestDto.getName())
                        .email(requestDto.getEmail())
                        .password(encodedPassword)
                        .build();

        Member savedMember = memberRepository.save(member);

        return SignupResponseDto.buildDto(savedMember);
    }

    public LoginResponseDto login(LoginRequestDto requestDto){
        String rawPassword = requestDto.getPassword();
        Member member = memberRepository.findByEmail(requestDto.getEmail()).orElseThrow(() -> new MemberNotFoundException());
        if (passwordEncoder.matches(rawPassword, member.getPassword())){
            return new LoginResponseDto(member.getId());
        } else {
            throw new InvalidPasswordException();
        }
    }
}
