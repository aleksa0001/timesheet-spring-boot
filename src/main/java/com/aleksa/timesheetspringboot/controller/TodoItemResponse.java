package com.aleksa.timesheetspringboot.controller;

import com.aleksa.timesheetspringboot.entity.TodoItem;

public class TodoItemResponse {
    private Long id;
    private String title;
    private Integer duration;

    public TodoItemResponse(TodoItem todoItem) {
        this.id = todoItem.getId();
        this.title = todoItem.getTitle();
        this.duration = todoItem.getDuration();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }
}