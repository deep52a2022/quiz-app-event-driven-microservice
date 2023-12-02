package com.quiz.app.event.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quiz.app.event.QuizCreatedEvent;

public class QuizCreatedEventSerializer extends GenericSerializer<QuizCreatedEvent> {
    public QuizCreatedEventSerializer() {
        super(new TypeReference<QuizCreatedEvent>() {});
    }
}
