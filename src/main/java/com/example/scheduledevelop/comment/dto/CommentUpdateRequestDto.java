package com.example.scheduledevelop.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    @NotNull(message = "댓글 내용은 필수입니다.")
    private String comment;

}
