package com.quiz.app.service;


import com.quiz.app.entity.QuizQuestionAnswer;
import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.event.listener.QuizSubmittedEventListener;
import com.quiz.app.kafka.CommonKafkaData;
import com.quiz.app.mapper.Mapper;
import com.quiz.app.model.QnAPair;
import com.quiz.app.repository.QuizQuestionAnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ScoreService implements QuizSubmittedEventListener {

    @Autowired
    private QuizQuestionAnswerRepository quizQuestionAnswerRepository;

    @Autowired
    private Mapper mapper;


    @KafkaListener(topics = CommonKafkaData.quizCreatedEventTopicName, groupId = CommonKafkaData.consumerGroupId)
    public ResponseEntity<?> updateQuizQuestionMappings(@Payload QuizCreatedEvent quizCreatedEvent) {
        List<QnAPair> answers = quizCreatedEvent.getQuizResponse().getAnswers();
        int quizId = quizCreatedEvent.getQuizResponse().getQuizId();
        answers.stream().forEach(
                qnAPair -> {
                    QuizQuestionAnswer quizQuestionAnswer =
                            mapper.qnaPairToQuizQuestionAnswer(qnAPair, quizId);
                    quizQuestionAnswerRepository.save(quizQuestionAnswer);
                }
        );
        log.info("Updated Corrected answer mappings for quiz id: {}", quizId);
        return new ResponseEntity(HttpStatus.OK);

    }

    public List<QuizQuestionAnswer> findQuesAnsByQuizId(int quizId){
        List<QuizQuestionAnswer> quizQuestionAnswers = quizQuestionAnswerRepository.findByQuizId(quizId);
        return quizQuestionAnswers;
    }
}
