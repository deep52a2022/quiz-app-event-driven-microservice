package com.quiz.app.event.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quiz.app.event.QuizCreatedEvent;

public class QuizCreatedEventDeserializer extends GenericDeserializer<QuizCreatedEvent>{
    public QuizCreatedEventDeserializer() {
        super(new TypeReference<QuizCreatedEvent>() {});
    }
}
