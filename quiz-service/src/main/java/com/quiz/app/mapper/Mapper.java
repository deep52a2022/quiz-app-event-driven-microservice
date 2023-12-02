package com.quiz.app.mapper;

import com.quiz.app.dto.QuestionDTO;
import com.quiz.app.dto.QuizDTO;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;
import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.model.QnAPair;
import com.quiz.app.model.QuizResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public QuestionDTO questionToQuestionDTO(Question question){
        return QuestionDTO.builder()
                .question_id(question.getQuestionId())
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
                .quizId(quiz.getQuizId())
                .build();
    }

    @Async("asyncTaskExecutorForQuizService")
    public CompletableFuture<QuizCreatedEvent> quizToQuizCreatedEvent(Quiz quiz) {
        QuizCreatedEvent quizCreatedEvent = new QuizCreatedEvent(
                        quizToCorrectQuizResponse(quiz),
                        ZonedDateTime.now()
                );
        return CompletableFuture.completedFuture(quizCreatedEvent);
    }
    public QuizResponse quizToCorrectQuizResponse(Quiz quiz){
        return QuizResponse.builder()
                .quizId(quiz.getQuizId())
                .answers(quiz.getQuestions().stream()
                        .map(question -> questionToQnAPairsWithRightAns(question)).collect(Collectors.toList()))
                .category(quiz.getCategory())
                .quizName(quiz.getTitle())
                .build();
    }

    public QnAPair questionToQnAPairsWithRightAns(Question question){
        return QnAPair.builder()
                .questionId(question.getQuestionId())
                .selectedOptionId(question.getCorrectOption().getOptionId())
                .build();

    }
}
