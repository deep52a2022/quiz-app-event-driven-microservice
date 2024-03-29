package com.quiz.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse  {
    private Integer quizId;
    private String quizTitle;
    private String category;
    private List<QnAPair> answers;
}
