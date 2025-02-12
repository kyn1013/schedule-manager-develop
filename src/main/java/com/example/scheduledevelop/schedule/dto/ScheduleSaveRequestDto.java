package com.example.scheduledevelop.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class ScheduleSaveRequestDto {
    @NotBlank
    private final Long memberId;
    @NotBlank
    @Range(max = 20)
    private final String title;
    @NotBlank
    private final String content;

    public ScheduleSaveRequestDto(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
}
