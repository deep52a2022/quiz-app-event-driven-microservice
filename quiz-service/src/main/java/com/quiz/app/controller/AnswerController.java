package com.quiz.app.controller;


import com.quiz.app.entity.AnswerOption;
import com.quiz.app.service.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ans")
public class AnswerController {

    @Autowired
    private AnswerOptionService answerOptionService;

    @GetMapping("/{id}")
    public AnswerOption getAnsById(@PathVariable Integer id){
        return answerOptionService.findAnswerOptionById(id);
    }
    @GetMapping("/hello")
    public  String hello(){
        return "AnserOption";
    }


}
