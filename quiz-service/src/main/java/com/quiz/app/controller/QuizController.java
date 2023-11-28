package com.quiz.app.controller;


import com.quiz.app.entity.Quiz;
import com.quiz.app.event.QuizSubmittedEvent;
import com.quiz.app.event.publisher.QuizSubmittedEventPublisher;
import com.quiz.app.model.QuizResponse;
import com.quiz.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @Autowired
    QuizSubmittedEventPublisher quizSubmittedEventPublisher;



    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam String category,
                                           @RequestParam int numQ,
                                           @RequestParam String title){
        quizService.createQuiz(category, numQ, title);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/take")
    public ResponseEntity<Quiz> takeQuiz(@RequestParam String category,
                                        @RequestParam int numQ,
                                        @RequestParam String title){
        Quiz quiz = quizService.createQuiz(category, numQ, title);

        return new ResponseEntity(quiz, HttpStatus.CREATED);
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int id){
        Quiz quiz = quizService.getQuizById(id);
        return new ResponseEntity(quiz, HttpStatus.OK);
    }




    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody QuizResponse quizResponse){
        QuizSubmittedEvent quizSubmittedEvent = QuizSubmittedEvent.builder()
                .quizResponse(quizResponse)
                .createdAt(ZonedDateTime.now())
                .build();
        quizSubmittedEventPublisher.publish(quizSubmittedEvent);
        return new ResponseEntity(HttpStatus.OK);
    }



}
