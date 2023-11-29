package com.quiz.app.model;

import com.quiz.app.entity.AnswerOption;

import java.util.Objects;

public class Answer {
    private Integer questionId;
    private AnswerOption selectedOption;

    public Answer(Integer questionId, AnswerOption selectedOption) {
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }
    public Answer(){}

    public Integer getQuestionId() {
        return questionId;
    }

    public AnswerOption getSelectedOption() {
        return selectedOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(questionId, answer.questionId) && Objects.equals(selectedOption, answer.selectedOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, selectedOption);
    }
}
