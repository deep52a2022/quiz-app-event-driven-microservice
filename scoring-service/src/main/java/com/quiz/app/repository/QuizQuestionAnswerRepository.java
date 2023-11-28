package com.quiz.app.repository;

import com.quiz.app.entity.QuizQuestionAnswer;
import com.quiz.app.entity.QuizQuestionAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizQuestionAnswerRepository extends JpaRepository<QuizQuestionAnswer, QuizQuestionAnswerId> {

    @Query(value = "SELECT CASE " +
            "WHEN q.correct_option_id := ansId THEN TRUE " +
            "ELSE FALSE END " +
            "FROM quiz_question_answer q " +
            "q.quiz_id := quizId AND question_id := questionId", nativeQuery = true)
    Long isAnswerCorrect(@Param("quizId") Integer quizId,
                         @Param("questionId") Integer questionId,
                         @Param("ansId") Integer ansId);

    List<QuizQuestionAnswer> findByQuizId(Integer quizId);
}
