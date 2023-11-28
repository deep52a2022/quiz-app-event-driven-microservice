package com.quiz.app.repository;

import com.quiz.app.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

    @Query(value = "SELECT q.* " +
            "FROM question q " +
            "JOIN quiz_question qq ON q.question_id = qq.question_id " +
            "WHERE qq.quiz_id = :quizId", nativeQuery = true)
    List<Question> findQuestionsByQuizId(@Param("quizId") Integer quizId);

    @Query(value = "SELECT" + " CASE" +
            " WHEN q.correct_option_id = :option_id THEN TRUE" +
            "        ELSE FALSE" +
            "    END" +
            " FROM" +
            "    question q" +
            " WHERE" +
            "    q.question_id = :question_id", nativeQuery = true)
    Long isAnswerCorrect(@Param("question_id") Integer questionId,
                            @Param("option_id") Integer answerId);


}
