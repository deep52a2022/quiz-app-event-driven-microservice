package com.quiz.app.controller;


import com.quiz.app.dto.QuizDTO;
import com.quiz.app.entity.Quiz;
import com.quiz.app.event.publisher.QuizSubmittedEventPublisher;
import com.quiz.app.mapper.Mapper;
import com.quiz.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    private Mapper mapper;

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
    public ResponseEntity<QuizDTO> takeQuiz(@RequestParam String category,
                                        @RequestParam int numQ,
                                        @RequestParam String title){
        QuizDTO quizDTO = quizService.createQuiz(category, numQ, title);

        return new ResponseEntity(quizDTO, HttpStatus.CREATED);
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable int id){
        Quiz quiz = quizService.getQuizById(id);
        QuizDTO quizDTO = mapper.quizToQuizDTO(quiz);
        return new ResponseEntity(quizDTO, HttpStatus.OK);
    }



}
