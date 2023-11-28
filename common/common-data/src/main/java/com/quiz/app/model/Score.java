package com.quiz.app.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Score {
    private int total;
    private int correct;
}
