package com.quiz.app.controller;

import com.quiz.app.entity.Question;
import com.quiz.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
//    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public Question getQUestionById(@PathVariable Integer id){
        return questionService.findQuestionById(id);
    }

    @GetMapping("/{questionId}/ans/{answerId}")
    public Boolean isAnswerCorrect(@PathVariable Integer questionId,
                                   @PathVariable Integer answerId){
        return questionService.isAnswerCorrect(questionId, answerId);
    }



}
