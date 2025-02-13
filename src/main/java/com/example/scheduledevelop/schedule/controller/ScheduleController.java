package com.example.scheduledevelop.schedule.controller;

import com.example.scheduledevelop.core.common.constants.Const;
import com.example.scheduledevelop.schedule.dto.SchedulePageResponseDto;
import com.example.scheduledevelop.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop.schedule.dto.ScheduleSaveRequestDto;
import com.example.scheduledevelop.schedule.dto.ScheduleUpdateRequestDto;
import com.example.scheduledevelop.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody @Valid ScheduleSaveRequestDto requestDto,
                                                    @SessionAttribute(name = Const.LOGIN_USER) Long userId){
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto, userId);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<SchedulePageResponseDto>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                 @RequestParam(value = "size", defaultValue = "10") int size){
        Page<SchedulePageResponseDto> scheduleResponseDto = scheduleService.findAll(page, size);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<ScheduleResponseDto> update(@RequestBody @Valid ScheduleUpdateRequestDto requestDto,
                                                      @SessionAttribute(name = Const.LOGIN_USER) Long userId){
        ScheduleResponseDto scheduleResponseDto = scheduleService.update(userId, requestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
