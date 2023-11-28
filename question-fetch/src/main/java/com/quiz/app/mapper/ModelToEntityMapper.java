package com.quiz.app.mapper;

import com.quiz.app.entity.AnswerOption;
import com.quiz.app.entity.Question;
import com.quiz.app.model.APIResponseObject;
import com.quiz.app.model.DifficultyLevel;
import com.quiz.app.model.QuestionAPIObject;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.quiz.app.utility.ServiceHelper.decode;

@Component
public class ModelToEntityMapper {



    public List<Question> aPIResponseObjectToQuestionList(APIResponseObject responseObject){
        responseObject = decodeResponseObject(responseObject);
        List<QuestionAPIObject> questionAPIObjects = responseObject.getResults();
        Map<String, DifficultyLevel> difficultyLevelMap = new HashMap<>();
        for(DifficultyLevel level : DifficultyLevel.values()){
            difficultyLevelMap.put(level.toString().toLowerCase(), level);
        }

        return questionAPIObjects.stream().map(
                questionObj -> {
                    List<AnswerOption> answerOptions = questionObj.getIncorrect_answers()
                            .stream().map(option -> AnswerOption.builder().optionText(option).build()).collect(Collectors.toList());
                    AnswerOption correctOption = AnswerOption.builder().optionText(questionObj.getCorrect_answer()).build();
                    answerOptions.add(correctOption);
                    Collections.shuffle(answerOptions);

                    return Question.Builder.builder()
                            .category(questionObj.getCategory())
                            .questionTitle(questionObj.getQuestion())
                            .difficultyLevel(difficultyLevelMap.get(questionObj.getDifficulty()))
                            .options(answerOptions.stream().collect(Collectors.toList()))
                            .correctOption(correctOption)
                            .build();

                }
        ).collect(Collectors.toList());


    }

    private APIResponseObject decodeResponseObject(APIResponseObject responseObject) {
        List<QuestionAPIObject> results = responseObject.getResults();
        for (int i = 0; i < results.size(); i++) {
            QuestionAPIObject cur = results.get(i);
            cur.setCategory(decode(cur.getCategory()));
            cur.setQuestion(decode(cur.getQuestion()));
            cur.setDifficulty(decode(cur.getDifficulty()));
            cur.setType(decode(cur.getType()));
            cur.setCorrect_answer(decode(cur.getCorrect_answer()));
            List<String> answers = cur.getIncorrect_answers();
            for(int j = 0; j < answers.size(); j++){
                answers.set(j, decode(answers.get(j)));
            }
        }
        return responseObject;
    }

}
