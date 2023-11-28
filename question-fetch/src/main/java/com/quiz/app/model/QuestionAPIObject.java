package com.quiz.app.model;

//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class QuestionAPIObject {
    private String type;
    private String difficulty;
    private String category;
    private String question;

//    @JsonProperty("correct_answer")
    private String correct_answer;

//    @JsonProperty("incorrect_answers")
    private List<String> incorrect_answers;
}
