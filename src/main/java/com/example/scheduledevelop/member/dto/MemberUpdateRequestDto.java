package com.example.scheduledevelop.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberUpdateRequestDto {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private final String name;
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "이메일 형식을 지켜주세요.")
    private final String email;

    public MemberUpdateRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
