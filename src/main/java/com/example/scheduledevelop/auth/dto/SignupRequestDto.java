package com.example.scheduledevelop.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequestDto {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private final String name;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "이메일 형식을 지켜주세요.")
    private final String email;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Size(max = 10, message = "비밀번호는 10자 이하로 해주세요.")
    private final String password;

    public SignupRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
