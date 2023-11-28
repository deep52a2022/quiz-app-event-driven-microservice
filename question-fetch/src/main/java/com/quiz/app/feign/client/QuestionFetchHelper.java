package com.quiz.app.feign.client;

import java.util.List;


public class QuestionFetchHelper {

    public static final List<String> difficultyLevels =
            List.of("easy", "medium", "hard" );

    public static final List<String> questionTypes =
            List.of("multiple", "boolean" );


    public static final String baseURL = "https://opentdb.com/api.php?";



}
