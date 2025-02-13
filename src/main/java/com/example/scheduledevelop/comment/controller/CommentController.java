package com.example.scheduledevelop.comment.controller;

import com.example.scheduledevelop.comment.dto.CommentSaveRequestDto;
import com.example.scheduledevelop.comment.dto.CommentResponseDto;
import com.example.scheduledevelop.comment.dto.CommentUpdateRequestDto;
import com.example.scheduledevelop.comment.service.CommentService;
import com.example.scheduledevelop.core.common.constants.Const;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<CommentResponseDto> save(@RequestBody @Valid CommentSaveRequestDto requestDto,
                                                   @SessionAttribute(name = Const.LOGIN_USER) Long userId){
        CommentResponseDto commentResponseDto = commentService.save(requestDto, userId);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id){
        CommentResponseDto commentResponseDto = commentService.findById(id);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CommentResponseDto>> findAll(){
        List<CommentResponseDto> commentResponseDto = commentService.findAll();
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<CommentResponseDto> update(@PathVariable Long id, @RequestBody @Valid CommentUpdateRequestDto requestDto){
//        CommentResponseDto commentResponseDto = commentService.update(id, requestDto);
//        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
//    }

    @PatchMapping()
    public ResponseEntity<CommentResponseDto> update(@RequestBody @Valid CommentUpdateRequestDto requestDto,
                                                     @SessionAttribute(name = Const.LOGIN_USER) Long userId){
        CommentResponseDto commentResponseDto = commentService.update(userId, requestDto);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
