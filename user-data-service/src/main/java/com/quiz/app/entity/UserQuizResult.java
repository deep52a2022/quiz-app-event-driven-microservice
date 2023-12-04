package com.quiz.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class UserQuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;
    private int userId;
    private String quizTitle;
    private String quizCategory;
    private int correct;
    private int total;
    private ZonedDateTime submittedOn;
}
