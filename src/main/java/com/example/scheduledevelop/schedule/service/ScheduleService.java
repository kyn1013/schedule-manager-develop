package com.example.scheduledevelop.schedule.service;

import com.example.scheduledevelop.core.common.exception.MemberNotFoundException;
import com.example.scheduledevelop.core.common.exception.ScheduleNotFoundException;
import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.core.entity.Schedule;
import com.example.scheduledevelop.member.repository.MemberRepository;
import com.example.scheduledevelop.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop.schedule.dto.ScheduleSaveRequestDto;
import com.example.scheduledevelop.schedule.dto.ScheduleUpdateRequestDto;
import com.example.scheduledevelop.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;
    public ScheduleResponseDto save(ScheduleSaveRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId()).orElseThrow(() -> new MemberNotFoundException());
        Schedule schedule = Schedule.builder()
                            .title(requestDto.getTitle())
                            .content(requestDto.getContent())
                            .build();

        schedule.setMember(member);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleResponseDto.buildDto(savedSchedule);
    }

    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new ScheduleNotFoundException());
        return ScheduleResponseDto.buildDto(schedule);
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        return ScheduleResponseDto.buildDtoList(scheduleList);
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new ScheduleNotFoundException());
        schedule.updateSchedule(requestDto.getTitle(), requestDto.getContent());
        return ScheduleResponseDto.buildDto(schedule);
    }

    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new ScheduleNotFoundException());
        scheduleRepository.delete(schedule);
    }
}
