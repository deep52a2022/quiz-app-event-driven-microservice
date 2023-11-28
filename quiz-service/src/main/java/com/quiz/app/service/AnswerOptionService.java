package com.quiz.app.service;

import com.quiz.app.entity.AnswerOption;
import com.quiz.app.repository.AnswerOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerOptionService {

    @Autowired
    private AnswerOptionRepository answerOptionRepository;


    public AnswerOption findAnswerOptionById(Integer id){
        Optional<AnswerOption> answerOption = answerOptionRepository.findById(id);
        return answerOption.get();
    }
}
