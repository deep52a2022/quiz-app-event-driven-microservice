package com.quiz.app.service;


import com.quiz.app.entity.QuizQuestionAnswer;
import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.event.QuizSubmittedEvent;
import com.quiz.app.event.listener.QuizSubmittedEventListener;
import com.quiz.app.event.publisher.QuizSubmittedEventPublisher;
import com.quiz.app.kafka.CommonKafkaData;
import com.quiz.app.mapper.Mapper;
import com.quiz.app.model.QnAPair;
import com.quiz.app.model.QuizResponse;
import com.quiz.app.model.Score;
import com.quiz.app.repository.QuizQuestionAnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScoreService implements QuizSubmittedEventListener {

    @Autowired
    private QuizQuestionAnswerRepository quizQuestionAnswerRepository;

    @Autowired
    private QuizSubmittedEventPublisher quizSubmittedEventPublisher;

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
        log.info("Updated Correct answer mappings for quiz id: {}", quizId);
        return new ResponseEntity(HttpStatus.OK);

    }

    public List<QuizQuestionAnswer> findQuesAnsByQuizId(int quizId){
        List<QuizQuestionAnswer> quizQuestionAnswers = quizQuestionAnswerRepository.findByQuizId(quizId);
        return quizQuestionAnswers;
    }

    public void processQuizResponse(QuizResponse quizResponse, String userId) {
        List<QnAPair> submittedQNAPairs = quizResponse.getAnswers();
        Set<QnAPair> correctQNAPairs = getCorrectQnApairs(quizResponse);
        Score score = getScore(submittedQNAPairs, correctQNAPairs);

        quizResponse.setAnswers(correctQNAPairs.stream().toList());

        QuizSubmittedEvent quizSubmittedEvent = new QuizSubmittedEvent(
                quizResponse,
                ZonedDateTime.now(),
                score,
                Integer.parseInt(userId)
        );

        quizSubmittedEventPublisher.publish(quizSubmittedEvent);
    }
    private Score getScore(List<QnAPair> submittedQNAPairs, Set<QnAPair> correctQNAPairs) {
        int correct = 0;
        int total = correctQNAPairs.size();
        for(QnAPair pair: submittedQNAPairs){
            if(correctQNAPairs.contains(pair)) correct++;
        }
        log.info("Score is {} out of {}", correct, total);
        return new Score(correct, total);
    }

    private Set<QnAPair> getCorrectQnApairs(QuizResponse quizResponse) {
        return findQuesAnsByQuizId(quizResponse.getQuizId().intValue()).stream().
                map(quesAns -> QnAPair.builder()
                        .selectedOptionId(quesAns.getCorrectOptionId())
                        .questionId(quesAns.getQuestionId())
                        .build()).collect(Collectors.toSet());
    }
}
