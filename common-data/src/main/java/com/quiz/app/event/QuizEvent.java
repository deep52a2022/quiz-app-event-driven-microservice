package com.quiz.app.event;

import com.quiz.app.model.QuizResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.ZonedDateTime;


@Getter
@ToString
@NoArgsConstructor
public class QuizEvent implements DomainEvent<QuizResponse>, Serializable {
    private QuizResponse quizResponse;
    private ZonedDateTime createdAt;

    public QuizEvent(QuizResponse quizResponse, ZonedDateTime createdAt) {
        this.quizResponse = quizResponse;
        this.createdAt = createdAt;
    }

}
