package com.quiz.app.model;

import lombok.Data;

import java.util.List;

@Data
public class APIResponseObject {

    private int response_code;
    private List<QuestionAPIObject> results;
}
