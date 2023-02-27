package com.aleksa.timesheetspringboot.repository;

import com.aleksa.timesheetspringboot.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
