package com.example.scheduledevelop.auth.service;

import com.example.scheduledevelop.auth.dto.SignupRequestDto;
import com.example.scheduledevelop.auth.dto.SignupResponseDto;
import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
