package com.example.scheduledevelop.schedule.controller;

import com.example.scheduledevelop.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop.schedule.dto.ScheduleSaveRequestDto;
import com.example.scheduledevelop.schedule.dto.ScheduleUpdateRequestDto;
import com.example.scheduledevelop.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.update(id, requestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
