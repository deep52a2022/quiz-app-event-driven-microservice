package com.quiz.app.repository;

import com.quiz.app.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface QuizRepository extends JpaRepository<Quiz, Integer> {


//
//    public default Quiz saveQuiz(Quiz quiz) {
//        Quiz savedQuiz = save(quiz);
//        List<Question> questions = questionRepository.findQuestionsByQuizId(savedQuiz.getQuizId());
////        questions.stream().forEach(question -> {
////            question.s
////        });
//        savedQuiz.setQuestions(questions);
//
//        return savedQuiz;
//    }

    // Other methods from JpaRepository<Quiz, Integer> can be used directly
}
