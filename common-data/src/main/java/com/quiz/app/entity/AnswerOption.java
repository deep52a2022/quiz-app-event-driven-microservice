package com.quiz.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Getter
@Setter
@Entity(name = "answer_option")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOption {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optionId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    private String optionText;

    public AnswerOption(String optionText) {
        this.optionText = optionText;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerOption that = (AnswerOption) o;
        return Objects.equals(optionId, that.optionId) && Objects.equals(question, that.question) && Objects.equals(optionText, that.optionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionId, question, optionText);
    }

    @Override
    public String toString() {
        return "AnswerOption{" +
                "optionId=" + optionId +
                ", question=" + question +
                ", optionText='" + optionText + '\'' +
                '}';
    }
}
