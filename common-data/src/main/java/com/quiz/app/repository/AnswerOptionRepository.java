package com.quiz.app.repository;


import com.quiz.app.entity.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Integer> {
    List<AnswerOption> findByQuestion_QuestionId(Integer questionId);

}
