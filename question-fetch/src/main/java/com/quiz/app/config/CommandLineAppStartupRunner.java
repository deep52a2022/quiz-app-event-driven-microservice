package com.quiz.app.config;


import com.quiz.app.service.QuestionPersistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final QuestionPersistService questionPersistService;
    public static int counter;

    public CommandLineAppStartupRunner(QuestionPersistService questionPersistService) {
        this.questionPersistService = questionPersistService;
    }

    @Override
    public void run(String...args) throws Exception {
        questionPersistService.addQuestions();
//        questionPersistService.initAddQuestions();
        log.info("Initialized adding questions");
    }
}