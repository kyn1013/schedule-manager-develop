package com.example.scheduledevelop.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class ScheduleSaveRequestDto {
    @NotNull(message = "사용자 id값은 필수입니다.")
    private final Long memberId;
    @NotBlank(message = "제목은 필수 입력값입니다.")
    @Range(max = 20)
    private final String title;
    @NotBlank(message = "내용은 필수 입력값입니다.")
    private final String content;

    public ScheduleSaveRequestDto(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
}
