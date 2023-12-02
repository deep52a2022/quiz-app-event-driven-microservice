package com.quiz.app.controller;


import com.quiz.app.model.QuizResponse;
import com.quiz.app.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/quiz")
@Slf4j
public class ScoringServiceController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("hello")
    public String hello(){
        return "Hello Score-Service";
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<?> submitQuiz(
            @RequestBody QuizResponse quizResponse,
            @PathVariable String userId){

        scoreService.processQuizResponse(quizResponse, userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
