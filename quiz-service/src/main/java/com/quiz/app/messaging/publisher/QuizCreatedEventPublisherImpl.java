package com.quiz.app.messaging.publisher;


import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.event.publisher.QuizCreatedEventPublisher;
import com.quiz.app.kafka.CommonKafkaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class QuizCreatedEventPublisherImpl implements QuizCreatedEventPublisher {

    @Autowired
    private KafkaTemplate<String, QuizCreatedEvent> template;

    @Override
    @Async("asyncTaskExecutorForQuizService")
    public void publish(QuizCreatedEvent QuizCreatedEvent) {
        try {
            CompletableFuture<SendResult<String, QuizCreatedEvent>> future =
                    template.send(CommonKafkaData.quizCreatedEventTopicName, QuizCreatedEvent);

            future.whenComplete((result,ex)->{
                if (ex == null) {
                    log.info("Published QuizCreatedEvent for quiz id: {}",
                            QuizCreatedEvent.getQuizResponse().getQuizId());
                } else {
                    log.info("Failed to Publish QuizCreatedEvent for quiz id: {}",
                            QuizCreatedEvent.getQuizResponse().getQuizId());
                }
            });
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
