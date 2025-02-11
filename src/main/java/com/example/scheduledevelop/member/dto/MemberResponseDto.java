package com.example.scheduledevelop.member.dto;

import com.example.scheduledevelop.auth.dto.SignupResponseDto;
import com.example.scheduledevelop.core.entity.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String name;
    private final String email;

    @Builder
    public MemberResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static MemberResponseDto buildDto (Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }

    public static List<MemberResponseDto> buildDtoList (List<Member> memberList) {
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        for (Member member : memberList){
            memberResponseDtos.add(MemberResponseDto.buildDto(member));
        }
        return memberResponseDtos;
    }
}
