package com.example.scheduledevelop.schedule.dto;

import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.core.entity.Schedule;
import com.example.scheduledevelop.member.dto.MemberResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    @Builder
    public ScheduleResponseDto(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static ScheduleResponseDto buildDto(Schedule schedule){
        return ScheduleResponseDto.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .author(schedule.getMember().getName())
                .build();
    }

    public static List<ScheduleResponseDto> buildDtoList (List<Schedule> scheduleList) {
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for (Schedule schedule : scheduleList){
            scheduleResponseDtos.add(ScheduleResponseDto.buildDto(schedule));
        }
        return scheduleResponseDtos;
    }
}
