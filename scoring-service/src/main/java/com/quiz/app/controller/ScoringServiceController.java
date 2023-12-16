package com.quiz.app.controller;


import com.quiz.app.model.QuizResponse;
import com.quiz.app.service.ScoreService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/submission")
@Slf4j
public class ScoringServiceController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello Score-Service";
    }

    @PostMapping(value = "/submit")
    public ResponseEntity<?> submitQuiz(
            @RequestBody QuizResponse quizResponse, HttpServletRequest request){
        String userId = request.getHeader("userId");
        log.info("UserId: {}",userId);
        scoreService.processQuizResponse(quizResponse, userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
