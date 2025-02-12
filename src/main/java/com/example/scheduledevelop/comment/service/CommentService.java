package com.example.scheduledevelop.comment.service;

import com.example.scheduledevelop.comment.dto.CommentSaveRequestDto;
import com.example.scheduledevelop.comment.dto.CommentResponseDto;
import com.example.scheduledevelop.comment.dto.CommentUpdateRequestDto;
import com.example.scheduledevelop.comment.repository.CommentRepository;
import com.example.scheduledevelop.core.common.exception.CommentNotFoundException;
import com.example.scheduledevelop.core.common.exception.MemberNotFoundException;
import com.example.scheduledevelop.core.common.exception.ScheduleNotFoundException;
import com.example.scheduledevelop.core.entity.Comment;
import com.example.scheduledevelop.core.entity.Member;
import com.example.scheduledevelop.core.entity.Schedule;
import com.example.scheduledevelop.member.repository.MemberRepository;
import com.example.scheduledevelop.schedule.repository.ScheduleRepository;
import jakarta.persistence.Temporal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public CommentResponseDto save(CommentSaveRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId()).orElseThrow(() -> new MemberNotFoundException());
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId()).orElseThrow(() -> new ScheduleNotFoundException());

        Comment comment = Comment.builder()
                                .content(requestDto.getComment())
                                .build();

        comment.setMember(member);
        comment.setSchedule(schedule);

        schedule.addComment(comment);

        Comment savedComment = commentRepository.save(comment);

        return CommentResponseDto.buildDto(savedComment);
    }

    @Transactional(readOnly = true)
    public CommentResponseDto findById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException());
        return CommentResponseDto.buildDto(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        return CommentResponseDto.buildDtoList(commentList);
    }

    @Transactional
    public CommentResponseDto update(Long id, CommentUpdateRequestDto requestDto) {
        Comment comment =  commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException());
        comment.updateComment(requestDto.getComment());
        return CommentResponseDto.buildDto(comment);
    }

    @Transactional
    public void delete(Long id) {
        Comment comment =  commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException());
        commentRepository.delete(comment);
    }
}
