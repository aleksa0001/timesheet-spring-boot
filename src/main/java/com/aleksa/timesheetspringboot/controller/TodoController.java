package com.aleksa.timesheetspringboot.controller;

import com.aleksa.timesheetspringboot.entity.TodoItem;
import com.aleksa.timesheetspringboot.service.TodoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/{date}")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItemRequest request,
                                                   @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        TodoItem todoItem = todoService.createTodoItem(request.getTitle(), request.getDuration(), date);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoItem.getId())
                .toUri();

        return ResponseEntity.created(location).body(todoItem);
    }

    @GetMapping
    public ResponseEntity<List<TodoItemResponse>> getTodoItemsForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<TodoItem> todoItems = todoService.getTodoItemsForDate(date);

        List<TodoItemResponse> todoItemResponses = todoItems.stream()
                .map(TodoItemResponse::new)
                .collect(Collectors.toList());

        Integer durationSum = todoService.getDurationSumForDate(date);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Duration", durationSum.toString());

        return ResponseEntity.ok().headers(headers).body(todoItemResponses);
    }
}