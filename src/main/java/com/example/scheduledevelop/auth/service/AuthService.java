package com.example.scheduledevelop.auth.service;

import com.example.scheduledevelop.auth.dto.LoginRequestDto;
import com.example.scheduledevelop.auth.dto.LoginResponseDto;
import com.example.scheduledevelop.auth.dto.SignupRequestDto;
import com.example.scheduledevelop.auth.dto.SignupResponseDto;
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

    @Transactional
    public SignupResponseDto signUp(SignupRequestDto requestDto) {
        Member member = Member.builder()
                        .name(requestDto.getName())
                        .email(requestDto.getEmail())
                        .password(requestDto.getPassword())
                        .build();

        Member savedMember = memberRepository.save(member);

        return SignupResponseDto.buildDto(savedMember);
    }

    public LoginResponseDto login(LoginRequestDto requestDto){
        Member member = memberRepository.findByEmail(requestDto.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (member.getPassword().equals(requestDto.getPassword())){
            return new LoginResponseDto(member.getId());
        } else {
            throw new RuntimeException("로그인 정보가 틀렸습니다.");
        }
    }
}
