package com.example.scheduledevelop.schedule.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponseDto {

    private final String title;
    private final String content;
    private final String author;
    private final Long commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    @Builder
    public SchedulePageResponseDto(String title, String content, String author, Long commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
