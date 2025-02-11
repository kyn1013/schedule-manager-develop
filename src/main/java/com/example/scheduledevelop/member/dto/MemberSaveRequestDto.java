package com.example.scheduledevelop.member.dto;

import lombok.Getter;

@Getter
public class MemberSaveRequestDto {

    private final String name;
    private final String email;
    private final String password;

    public MemberSaveRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
