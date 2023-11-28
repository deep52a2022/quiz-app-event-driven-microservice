package com.quiz.app.dto;

import com.quiz.app.entity.AnswerOption;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDTO {
    private String questionTitle;
    private List<AnswerOption> options;
    private String difficultyLevel;
}
