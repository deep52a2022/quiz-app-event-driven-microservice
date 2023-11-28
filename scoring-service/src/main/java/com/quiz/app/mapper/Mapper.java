package com.quiz.app.mapper;

import com.quiz.app.entity.QuizQuestionAnswer;
import com.quiz.app.model.QnAPair;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public QuizQuestionAnswer qnaPairToQuizQuestionAnswer(QnAPair qnAPair, int quizId){
        return QuizQuestionAnswer.builder()
                .quizId(quizId)
                .questionId(qnAPair.getQuestionId())
                .correctOptionId(qnAPair.getSelectedOptionId())
                .build();
    }
}
