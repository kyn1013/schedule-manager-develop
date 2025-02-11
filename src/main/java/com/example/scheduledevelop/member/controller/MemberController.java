package com.example.scheduledevelop.member.controller;

import com.example.scheduledevelop.auth.dto.SignupRequestDto;
import com.example.scheduledevelop.auth.dto.SignupResponseDto;
import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.member.dto.MemberResponseDto;
import com.example.scheduledevelop.member.dto.MemberUpdateRequestDto;
import com.example.scheduledevelop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        MemberResponseDto memberResponseDto = memberService.findById(id);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();
        return new ResponseEntity<>(memberResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberResponseDto> update(@PathVariable Long id, @RequestBody MemberUpdateRequestDto updateRequestDto){
        MemberResponseDto memberResponseDto = memberService.update(id, updateRequestDto);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
