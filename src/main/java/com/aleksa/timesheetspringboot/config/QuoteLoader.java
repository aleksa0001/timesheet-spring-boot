package com.aleksa.timesheetspringboot.config;

import com.aleksa.timesheetspringboot.entity.Quote;
import com.aleksa.timesheetspringboot.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuoteLoader implements CommandLineRunner {
    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public void run(String... args) throws Exception {
        quoteRepository.save(new Quote("Be the change that you wish to see in the world", "Mahatma Gandhi"));
        quoteRepository.save(new Quote("Imagination is more important than knowledge", "Albert Einstein"));
        quoteRepository.save(new Quote("I have not failed. I've just found 10,000 ways that won't work", "Thomas Edison"));
    }
}