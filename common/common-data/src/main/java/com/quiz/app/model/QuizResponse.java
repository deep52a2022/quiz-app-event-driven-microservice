package com.quiz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuizResponse {
    private Integer quizId;
    private List<QnAPair> answers;
}
