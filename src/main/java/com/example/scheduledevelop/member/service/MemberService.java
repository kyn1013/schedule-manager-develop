package com.example.scheduledevelop.member.service;

import com.example.scheduledevelop.core.common.exception.MemberNotFoundException;
import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.member.dto.MemberResponseDto;
import com.example.scheduledevelop.member.dto.MemberUpdateRequestDto;
import com.example.scheduledevelop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException());
        return MemberResponseDto.buildDto(member);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> memberList = memberRepository.findAll();
        return MemberResponseDto.buildDtoList(memberList);
    }

    @Transactional
    public MemberResponseDto update(Long id, MemberUpdateRequestDto updateRequestDto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException());
        member.updateMember(updateRequestDto.getName(), updateRequestDto.getEmail());
        return MemberResponseDto.buildDto(member);
    }

    @Transactional
    public void delete(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException());
        memberRepository.delete(member);
    }
}
