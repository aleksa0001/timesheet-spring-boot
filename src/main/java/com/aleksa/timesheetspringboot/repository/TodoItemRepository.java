package com.aleksa.timesheetspringboot.repository;

import com.aleksa.timesheetspringboot.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByDate(LocalDate date);
}
