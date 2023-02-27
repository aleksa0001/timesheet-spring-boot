package com.aleksa.timesheetspringboot.service;

import com.aleksa.timesheetspringboot.entity.TodoItem;
import com.aleksa.timesheetspringboot.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    private final TodoItemRepository todoItemRepository;

    public TodoService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItem createTodoItem(String title, Integer duration, LocalDate date) {
        // Check if the sum of todos items for the specified date is greater than 8
        Integer sumDuration = todoItemRepository.findByDate(date)
                .stream()
                .map(TodoItem::getDuration)
                .reduce(0, Integer::sum);

        if (sumDuration + duration > 8) {
            throw new IllegalArgumentException("The sum of todo items for this day is greater than 8");
        }

        // Create and save the new todos item
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(title);
        todoItem.setDuration(duration);
        todoItem.setDate(date);

        return todoItemRepository.save(todoItem);
    }

    public List<TodoItem> getTodoItemsForDate(LocalDate date) {
        return todoItemRepository.findByDate(date);
    }

    public Integer getDurationSumForDate(LocalDate date) {
        return todoItemRepository.findByDate(date)
                .stream()
                .map(TodoItem::getDuration)
                .reduce(0, Integer::sum);
    }
}