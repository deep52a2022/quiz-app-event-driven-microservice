package com.quiz.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizId;
    private String title;
    private String category;

    @ManyToMany
    @JoinTable(
            name = "quiz_question",
            joinColumns = {@JoinColumn(name = "quiz_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")}
    )

    private List<Question> questions;
    // without @JoinTable: table : quiz_questions, cols: quiz_quiz_id, questions_question_id
}
