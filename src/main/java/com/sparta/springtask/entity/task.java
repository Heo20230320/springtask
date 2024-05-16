package com.sparta.springtask.entity;

import com.sparta.springtask.dto.taskRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class task {
    private Long taskId;
    private String title;
    private String content;
    private String manager;
    private String password;
    private Timestamp time;

    public task(taskRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();

    }

    public void update(taskRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
    }
}

