package com.quiz.app.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Score{

    private int correct;
    private int total;

    public Score(int correct, int total) {
        this.correct = correct;
        this.total = total;
    }
}
