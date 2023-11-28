package com.quiz.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.app.entity.AnswerOption;
import com.quiz.app.entity.Question;
import com.quiz.app.feign.client.FeignFetchQuestions;
import com.quiz.app.mapper.ModelToEntityMapper;
import com.quiz.app.model.APIResponseObject;
import com.quiz.app.repository.AnswerOptionRepository;
import com.quiz.app.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.quiz.app.feign.client.QuestionFetchHelper.difficultyLevels;
import static com.quiz.app.feign.client.QuestionFetchHelper.questionTypes;

@Slf4j
@Service
public class QuestionPersistService {


    private final FeignFetchQuestions fetchQuestions;


    private  final ModelToEntityMapper mapper;


    private  final QuestionRepository questionRepository;
    private final ObjectMapper objectMapper;
    private final AnswerOptionRepository answerOptionRepository;


    private static Random random = new Random();

    public QuestionPersistService(FeignFetchQuestions fetchQuestions,
                                  ModelToEntityMapper mapper,
                                  QuestionRepository questionRepository,
                                  ObjectMapper objectMapper,
                                  AnswerOptionRepository answerOptionRepository) {
        this.fetchQuestions = fetchQuestions;
        this.mapper = mapper;
        this.questionRepository = questionRepository;
        this.objectMapper = objectMapper;
        this.answerOptionRepository = answerOptionRepository;
    }

    @Async("asyncTaskExecutor")
    public void addQuestions() throws JsonProcessingException, InterruptedException {
        String json = fetchQuestions.getAPIResponse(random.nextInt(5, 50),
                difficultyLevels.get(random.nextInt(difficultyLevels.size())),
                questionTypes.get(random.nextInt(questionTypes.size())), random.nextInt(11, 32) , "base64"
//                random.nextInt(9, 33)
        );


        APIResponseObject apiResponse = objectMapper.readValue(json, APIResponseObject.class);
//        if(apiResponse.getResponse_code() == 5 ){
////            return apiResponse.getResponse_code();
//            Thread.sleep(5500);
//            addQuestions();
//            return;
//        }
//        if(apiResponse.getResponse_code() > 0 ){
////            return apiResponse.getResponse_code();
//            Thread.sleep(1000);
//            addQuestions();
//            return;
//        }



        List<Question> questions = mapper.aPIResponseObjectToQuestionList(apiResponse);
        for (Question question: questions){
            log.info(question.getQuestionTitle());
            questionRepository.save(question);
            List<AnswerOption> answerOptions = question.getOptions();
            for(AnswerOption answerOption: answerOptions){
                answerOption.setQuestion(question);
                answerOptionRepository.save(answerOption);
                Thread.sleep(50);
            }
        }
        log.info("Saved {} questions", questions.size());
        log.info("Response Code: {}", apiResponse.getResponse_code());
//        return 0;
    }

//    @Async("asyncTaskExecutor")
//    public void initAddQuestions() throws JsonProcessingException, InterruptedException {
//        while(true){
//            int ResponseCode = addQuestions();
//            if(ResponseCode == 0) break;
//            if(ResponseCode == 5) Thread.sleep(5500);
//        }
//    }
}
