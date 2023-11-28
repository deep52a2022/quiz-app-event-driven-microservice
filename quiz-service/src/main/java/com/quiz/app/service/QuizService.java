package com.quiz.app.service;

import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;
import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.event.publisher.QuizCreatedEventPublisher;
import com.quiz.app.mapper.Mapper;
import com.quiz.app.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuizService {

    @Autowired
    private  QuizRepository quizRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private Mapper mapper;
    @Autowired
    QuizCreatedEventPublisher quizCreatedEventPublisher;

    public Quiz createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionService.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = Quiz.builder()
                .title(title)
                .category(category)
                .questions(questions)
                .build();
        Quiz savedQuiz = quizRepository.save(quiz);
        savedQuiz = getQuizById(savedQuiz.getQuizId());
        publishQuizCreatedEvent(savedQuiz);
        return savedQuiz;
    }

    @Async("asyncTaskExecutorForQuizService")
    private void publishQuizCreatedEvent(Quiz savedQuiz) {
        QuizCreatedEvent quizCreatedEvent = mapper.quizToQuizCreatedEvent(savedQuiz);
        quizCreatedEventPublisher.publish(quizCreatedEvent);
    }

    public Quiz getQuizById(int quizId){
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        List<Question> quizQuestions = questionService.findQuestionsByQuizId(quizId);
        quiz.get().setQuestions(quizQuestions);
        return quiz.get();
    }



}
