package com.quiz.app.controller;


import com.quiz.app.model.QuizResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/quiz")
public class ScoringServiceController {

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody QuizResponse quizResponse){

        return new ResponseEntity(HttpStatus.OK);
    }

}
