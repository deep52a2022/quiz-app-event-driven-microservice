package com.quiz.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizDTO {
    private Integer quizId;
    private List<QuestionDTO> questions;
    private String category;
}
