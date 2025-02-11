package com.example.scheduledevelop.auth.dto;

import com.example.scheduledevelop.core.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private final Long id;
    private final String name;
    private final String email;

    @Builder
    public SignupResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static SignupResponseDto buildDto (Member member) {
        return SignupResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
