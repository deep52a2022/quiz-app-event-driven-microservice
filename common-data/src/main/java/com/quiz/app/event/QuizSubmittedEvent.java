package com.quiz.app.event;


import com.quiz.app.model.QuizResponse;
import com.quiz.app.model.Score;

import java.time.ZonedDateTime;

public class QuizSubmittedEvent extends QuizEvent{
    private int userId;
    private Score score;
    public QuizSubmittedEvent(QuizResponse quizResponse,
                              ZonedDateTime createdAt,
                              Score score,
                              int userId) {
        super(quizResponse, createdAt);
        this.score = score;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public Score getScore() {
        return score;
    }
}
