package com.quiz.app.event;


import com.quiz.app.model.QuizResponse;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class QuizSubmittedEvent implements DomainEvent<QuizResponse> {

    private QuizResponse quizResponse;
    private ZonedDateTime createdAt;

}
