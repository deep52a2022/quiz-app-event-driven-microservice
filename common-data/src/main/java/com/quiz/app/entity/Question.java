package com.quiz.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quiz.app.model.DifficultyLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    private String questionTitle;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<AnswerOption> options;

    @ManyToOne
    @JoinColumn(name = "correct_option_id")
    private AnswerOption correctOption;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level")
    private DifficultyLevel difficultyLevel;

    @JsonIgnore
    private String category;

    private Question(Builder builder) {
        setQuestionId(builder.questionId);
        setQuestionTitle(builder.questionTitle);
        setOptions(builder.options);
        setCorrectOption(builder.correctOption);
        setDifficultyLevel(builder.difficultyLevel);
        setCategory(builder.category);
    }

    public void addOption(AnswerOption option) {
        options.add(option);
        option.setQuestion(this);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionTitle='" + questionTitle + '\'' +
                ", options=" + options +
                ", correctOption=" + correctOption +
                ", difficultyLevel=" + difficultyLevel +
                ", category='" + category + '\'' +
                '}';
    }

    public static final class Builder {
        private Integer questionId;
        private String questionTitle;
        private List<AnswerOption> options;
        private AnswerOption correctOption;
        private DifficultyLevel difficultyLevel;
        private String category;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder questionId(Integer val) {
            questionId = val;
            return this;
        }

        public Builder questionTitle(String val) {
            questionTitle = val;
            return this;
        }

        public Builder options(List<AnswerOption> val) {
            options = val;
            return this;
        }

        public Builder correctOption(AnswerOption val) {
            correctOption = val;
            return this;
        }

        public Builder difficultyLevel(DifficultyLevel val) {
            difficultyLevel = val;
            return this;
        }

        public Builder category(String val) {
            category = val;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}

