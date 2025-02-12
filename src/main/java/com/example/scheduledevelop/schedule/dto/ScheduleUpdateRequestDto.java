package com.example.scheduledevelop.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    @NotBlank(message = "제목은 필수 입력값입니다.")
    @Size(max = 20)
    private final String title;
    @NotBlank(message = "내용은 필수 입력값입니다.")
    private final String content;

    public ScheduleUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
