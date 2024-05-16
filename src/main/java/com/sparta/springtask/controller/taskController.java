package com.sparta.springtask.controller;

import com.sparta.springtask.dto.taskRequestDto;
import com.sparta.springtask.dto.taskResponseDto;
import com.sparta.springtask.entity.task;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class taskController {
    private final Map<Long, task> taskList = new HashMap<>();


    // Step 1 : 등록
    @PostMapping("/tasks")
    public taskResponseDto createTask(@RequestBody taskRequestDto requestDto) {
        task task_new = new task(requestDto);


        // make ID
        Long newId = taskList.size() > 0 ? Collections.max(taskList.keySet()) + 1 : 1;
        // 현재 시간정보 반환
        Timestamp time = new Timestamp(System.currentTimeMillis());
        task_new.setTime(time);
        task_new.setTaskId(newId);


        taskList.put(newId, task_new);

        //Entity -> ResponseDto
        taskResponseDto responseDto = new taskResponseDto(task_new);

        return responseDto;
    }

    // Step 3 : 전체 일정
    @GetMapping("/tasks")
    public List<taskResponseDto> getAllTasks() {
        List<taskResponseDto> responseDtoList = taskList.values().stream().map(taskResponseDto::new).toList();
        return responseDtoList;
    }
}
