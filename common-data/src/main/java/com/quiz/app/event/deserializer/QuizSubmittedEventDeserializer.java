package com.quiz.app.event.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quiz.app.event.QuizSubmittedEvent;

public class QuizSubmittedEventDeserializer extends GenericDeserializer<QuizSubmittedEvent>{
    public QuizSubmittedEventDeserializer() {
        super(new TypeReference<QuizSubmittedEvent>() {});
    }
}
