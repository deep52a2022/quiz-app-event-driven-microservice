package com.quiz.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(QuizQuestionAnswerId.class)
public class QuizQuestionAnswer {

    @Id
    private int quizId;
    @Id
    private int questionId;
    private int correctOptionId;

}
