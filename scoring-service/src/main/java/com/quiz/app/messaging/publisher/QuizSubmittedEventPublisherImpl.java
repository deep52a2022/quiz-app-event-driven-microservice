package com.quiz.app.messaging.publisher;

import com.quiz.app.event.QuizSubmittedEvent;
import com.quiz.app.event.publisher.QuizSubmittedEventPublisher;
import com.quiz.app.kafka.CommonKafkaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class QuizSubmittedEventPublisherImpl implements QuizSubmittedEventPublisher {

    @Autowired
    private KafkaTemplate<String, QuizSubmittedEvent> template;

    @Override
    public void publish(QuizSubmittedEvent quizSubmittedEvent) {
        try {
            CompletableFuture<SendResult<String, QuizSubmittedEvent>> future =
                    template.send(CommonKafkaData.quizSubmittedEventTopicName, quizSubmittedEvent);

            future.whenComplete((result,ex)->{
                if (ex == null) {
                    log.info("Published QuizSubmittedEvent for quiz id: {}",
                            quizSubmittedEvent.getQuizResponse().getQuizId());
                } else {
                    log.info("Failed to Publish QuizSubmittedEvent for quiz id: {}",
                            quizSubmittedEvent.getQuizResponse().getQuizId());
                }
            });
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
