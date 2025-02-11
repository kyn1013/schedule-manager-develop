package com.example.scheduledevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {
    private final Long memberId;
    private final String title;
    private final String content;

    public ScheduleSaveRequestDto(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
}
