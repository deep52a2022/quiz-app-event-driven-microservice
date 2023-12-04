package com.quiz.app.repository;

import com.quiz.app.entity.UserQuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuizResultRepository extends JpaRepository<UserQuizResult, Integer> {
}
