package com.quiz.app.service;

import com.quiz.app.dto.QuizDTO;
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
import java.util.concurrent.ExecutionException;

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

    public QuizDTO createQuiz(String category, int numQ, String title){
        List<Question> questions = questionService.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = Quiz.builder()
                .title(title)
                .category(category)
                .questions(questions)
                .build();
        Quiz savedQuiz = quizRepository.save(quiz);
        savedQuiz = getQuizById(savedQuiz.getQuizId());
        publishQuizCreatedEvent(savedQuiz);
        return mapper.quizToQuizDTO(savedQuiz);
    }

    public QuizDTO getQuizDTOById(Integer id){
        Quiz quiz = getQuizById(id);
        return mapper.quizToQuizDTO(quiz);
    }

    @Async("asyncTaskExecutorForQuizService")
    private void publishQuizCreatedEvent(Quiz savedQuiz) {
        QuizCreatedEvent quizCreatedEvent;
        try {
            quizCreatedEvent = mapper.quizToQuizCreatedEvent(savedQuiz).get();
            quizCreatedEventPublisher.publish(quizCreatedEvent);
        } catch (ExecutionException | InterruptedException e){
            log.info(e.getMessage());
        }


    }

    public Quiz getQuizById(int quizId){
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        List<Question> quizQuestions = questionService.findQuestionsByQuizId(quizId);
        quiz.get().setQuestions(quizQuestions);
        return quiz.get();
    }



}
