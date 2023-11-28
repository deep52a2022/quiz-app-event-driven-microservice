package com.quiz.app.mapper;

import com.quiz.app.dto.QuestionDTO;
import com.quiz.app.dto.QuizDTO;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;
import com.quiz.app.event.QuizCreatedEvent;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public QuestionDTO questionToQuestionDTO(Question question){
        return QuestionDTO.builder()
                .questionTitle(question.getQuestionTitle())
                .difficultyLevel(question.getDifficultyLevel().toString())
                .options(question.getOptions().stream().collect(Collectors.toList()))
                .build();
    }

    public QuizDTO quizToQuizDTO(Quiz quiz){
        List<QuestionDTO> questionDTOS = quiz.getQuestions().stream()
                .map(question -> questionToQuestionDTO(question)).collect(Collectors.toList());
        return QuizDTO.builder()
                .category(quiz.getCategory())
                .questions(questionDTOS)
                .build();
    }

    public QuizCreatedEvent quizToQuizCreatedEvent(Quiz quiz) {
        return QuizCreatedEvent.builder()
                .quiz(quiz)
                .createdAt(ZonedDateTime.now())
                .build();
    }
}
