package com.quiz.app.event;


import com.quiz.app.model.QuizResponse;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@NoArgsConstructor
public class QuizCreatedEvent extends QuizEvent{
    public QuizCreatedEvent(QuizResponse quizResponse, ZonedDateTime createdAt) {
        super(quizResponse, createdAt);
    }
}
