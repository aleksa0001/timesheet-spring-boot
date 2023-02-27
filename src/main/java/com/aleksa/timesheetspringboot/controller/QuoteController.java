package com.aleksa.timesheetspringboot.controller;

import com.aleksa.timesheetspringboot.entity.Quote;
import com.aleksa.timesheetspringboot.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    @GetMapping("/quote")
    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        int randomIndex = (int) (Math.random() * quotes.size());
        return quotes.get(randomIndex);
    }
}
