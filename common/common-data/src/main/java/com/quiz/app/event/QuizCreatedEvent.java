package com.quiz.app.event;

import com.quiz.app.entity.Quiz;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class QuizCreatedEvent implements DomainEvent<Quiz>{
    private Quiz quiz;
    private ZonedDateTime createdAt;

}
