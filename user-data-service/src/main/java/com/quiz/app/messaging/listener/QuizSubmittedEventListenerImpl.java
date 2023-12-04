package com.quiz.app.messaging.listener;


import com.quiz.app.entity.UserQuizResult;
import com.quiz.app.event.QuizSubmittedEvent;
import com.quiz.app.event.listener.QuizSubmittedEventListener;
import com.quiz.app.kafka.CommonKafkaData;
import com.quiz.app.repository.UserQuizResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuizSubmittedEventListenerImpl implements QuizSubmittedEventListener<Void> {

    @Autowired
    private UserQuizResultRepository repository;

    @Override
    @KafkaListener(
            topics = CommonKafkaData.quizSubmittedEventTopicName,
            groupId = CommonKafkaData.consumerGroupId)
    public Void processEvent(QuizSubmittedEvent event) {
        UserQuizResult result = quizSubmittedEventToUserQuizSummary(event);
        repository.save(result);
        log.info("Saved result for quizId: {} and userId: {}",
                event.getQuizResponse().getQuizId(), event.getUserId());
        return null;
    }

    public UserQuizResult quizSubmittedEventToUserQuizSummary(QuizSubmittedEvent event){
        return UserQuizResult.builder()
                .userId(event.getUserId())
                .submittedOn(event.getCreatedAt())
                .quizTitle(event.getQuizResponse().getQuizTitle())
                .correct(event.getScore().getCorrect())
                .quizCategory(event.getQuizResponse().getCategory())
                .total(event.getScore().getTotal())
                .build();
    }
}
