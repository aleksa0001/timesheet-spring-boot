package com.aleksa.timesheetspringboot.controller;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class TodoItemRequest {
    @NotNull
    private String title;
    @NotNull
    private Integer duration;
    private LocalDate date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
