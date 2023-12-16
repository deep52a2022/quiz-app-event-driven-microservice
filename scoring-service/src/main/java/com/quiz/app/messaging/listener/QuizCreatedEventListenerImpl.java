package com.quiz.app.messaging.listener;

import com.quiz.app.entity.QuizQuestionAnswer;
import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.event.listener.QuizCreatedEventListener;
import com.quiz.app.kafka.CommonKafkaData;
import com.quiz.app.mapper.Mapper;
import com.quiz.app.model.QnAPair;
import com.quiz.app.repository.QuizQuestionAnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

@Slf4j
public class QuizCreatedEventListenerImpl implements QuizCreatedEventListener<Void> {

    @Autowired
    private Mapper mapper;

    @Autowired
    QuizQuestionAnswerRepository quizQuestionAnswerRepository;

    @Override
    @KafkaListener(
            topics = CommonKafkaData.quizCreatedEventTopicName,
            groupId = CommonKafkaData.consumerGroupId)
    public Void processEvent(@Payload QuizCreatedEvent quizCreatedEvent) {
        List<QnAPair> answers = quizCreatedEvent.getQuizResponse().getAnswers();
        int quizId = quizCreatedEvent.getQuizResponse().getQuizId();
        answers.stream().forEach(
                qnAPair -> {
                    QuizQuestionAnswer quizQuestionAnswer =
                            mapper.qnaPairToQuizQuestionAnswer(qnAPair, quizId);
                    quizQuestionAnswerRepository.save(quizQuestionAnswer);
                }
        );
        log.info("Updated Correct answer mappings for quiz id: {}", quizId);
        return null;
    }
}
