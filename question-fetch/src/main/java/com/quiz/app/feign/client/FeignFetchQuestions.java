package com.quiz.app.feign.client;


import com.quiz.app.config.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.quiz.app.feign.client.QuestionFetchHelper.baseURL;


@FeignClient(value = "fetch-questions" ,url = baseURL,
configuration = ClientConfiguration.class)
public interface FeignFetchQuestions {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api.php",
            produces = "application/json")
    String getAPIResponse(@RequestParam("amount") int amount,
                                     @RequestParam("difficulty") String difficulty,
                                     @RequestParam("type") String questionType,
                                     @RequestParam("category") int category,
                                     @RequestParam("encode") String encode);
}

