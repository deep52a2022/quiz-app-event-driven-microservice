package com.quiz.app.service;

import com.quiz.app.entity.AnswerOption;
import com.quiz.app.entity.Question;
import com.quiz.app.repository.AnswerOptionRepository;
import com.quiz.app.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Component
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    public Question findQuestionById(Integer id){
        Optional<Question> question = questionRepository.findById(id);
        List<AnswerOption> answerOptions = answerOptionRepository
                .findByQuestion_QuestionId(question.get().getQuestionId());
        question.get().setOptions(answerOptions);
        return question.get();
    }

    public List<Question> findRandomQuestionsByCategory(String category, int numQ){
        List<Question> randomQuestionsByCategory = questionRepository.findRandomQuestionsByCategory(category, numQ);
        return randomQuestionsByCategory;
    }

    @Transactional
    public List<Question> findQuestionsByQuizId(Integer quizId){
        List<Question> questionsByQuizId = questionRepository.findQuestionsByQuizId(quizId);
        for(Question question: questionsByQuizId){
            question = findQuestionById(question.getQuestionId());
        }
        return questionsByQuizId;
    }

    public Boolean isAnswerCorrect(Integer questionId, Integer answerId){
        Long answerCorrect = questionRepository.isAnswerCorrect(questionId, answerId);
        if(answerCorrect == null) return false;
        return answerCorrect == 0l ? false : true;
    }

}
