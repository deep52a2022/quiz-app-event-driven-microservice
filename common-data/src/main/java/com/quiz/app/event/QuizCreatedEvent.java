package com.quiz.app.event;

import com.quiz.app.entity.Quiz;
import com.quiz.app.model.QuizResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizCreatedEvent implements DomainEvent<Quiz>{
    private QuizResponse quizResponse;
    private ZonedDateTime createdAt;

}
