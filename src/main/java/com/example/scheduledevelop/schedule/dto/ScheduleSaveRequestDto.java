package com.example.scheduledevelop.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {
    @NotBlank(message = "제목은 필수 입력값입니다.")
    @Size(max = 20)
    private String title;
    @NotBlank(message = "내용은 필수 입력값입니다.")
    private String content;

}
