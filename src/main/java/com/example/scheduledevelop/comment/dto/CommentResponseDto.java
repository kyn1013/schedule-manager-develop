package com.example.scheduledevelop.comment.dto;

import com.example.scheduledevelop.core.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommentResponseDto {

    private final Long id;
    private final String author;
    private final String comment;

    @Builder
    public CommentResponseDto(Long id, String author, String comment) {
        this.id = id;
        this.author = author;
        this.comment = comment;
    }

    public static CommentResponseDto buildDto(Comment comment){
        return CommentResponseDto.builder()
                .id(comment.getId())
                .author(comment.getMember().getName())
                .comment(comment.getContent())
                .build();
    }

    public static List<CommentResponseDto> buildDtoList (List<Comment> commentList) {
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : commentList){
            commentResponseDtos.add(CommentResponseDto.buildDto(comment));
        }
        return commentResponseDtos;
    }
}
