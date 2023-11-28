package com.quiz.app.controller;


import com.quiz.app.model.QnAPair;
import com.quiz.app.model.QuizResponse;
import com.quiz.app.model.Score;
import com.quiz.app.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController("/quiz")
@Slf4j
public class ScoringServiceController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody QuizResponse quizResponse){
        List<QnAPair> submittedQNAPairs = quizResponse.getAnswers();
        Set<QnAPair> correctQNAPairs =
                scoreService.findQuesAnsByQuizId(quizResponse.getQuizId().intValue())
                        .stream().map(quesAns -> {
                            return QnAPair.builder()
                                    .selectedOptionId(quesAns.getCorrectOptionId())
                                    .questionId(quesAns.getQuestionId())
                                    .build();

                        }).collect(Collectors.toSet());

        int correct = 0;
        int total = correctQNAPairs.size();
        for(QnAPair pair: submittedQNAPairs){
            if(correctQNAPairs.contains(pair)) correct++;
        }
        Score score = Score.builder().correct(correct).total(total).build();
        log.info("Score is {} out of {}", correct, total);
        return new ResponseEntity<>(score, HttpStatus.OK);

    }

}
