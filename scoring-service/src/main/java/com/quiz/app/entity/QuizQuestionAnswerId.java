package com.quiz.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizQuestionAnswerId implements Serializable {
    private int quizId;
    private int questionId;
}
