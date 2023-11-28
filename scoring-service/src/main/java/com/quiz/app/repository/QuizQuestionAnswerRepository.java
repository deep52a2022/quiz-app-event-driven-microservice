package com.quiz.app.repository;

import com.quiz.app.entity.QuizQuestionAnswer;
import com.quiz.app.entity.QuizQuestionAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionAnswerRepository extends JpaRepository<QuizQuestionAnswer, QuizQuestionAnswerId> {
}
