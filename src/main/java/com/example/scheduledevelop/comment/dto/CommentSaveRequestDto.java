package com.example.scheduledevelop.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    @NotNull(message = "일정 id값은 필수입니다.")
    private final Long scheduleId;
    @NotNull(message = "사용자 id값은 필수입니다.")
    private final Long memberId;
    @NotNull(message = "댓글 내용은 필수입니다.")
    private final String comment;

    public CommentSaveRequestDto(Long scheduleId, Long memberId, String comment) {
        this.scheduleId = scheduleId;
        this.memberId = memberId;
        this.comment = comment;
    }
}
