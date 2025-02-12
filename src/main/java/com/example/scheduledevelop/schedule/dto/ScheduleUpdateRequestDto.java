package com.example.scheduledevelop.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class ScheduleUpdateRequestDto {

    @NotBlank
    @Range(max = 20)
    private final String title;
    @NotBlank
    private final String content;

    public ScheduleUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
