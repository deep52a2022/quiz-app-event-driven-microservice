package com.quiz.app.event.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quiz.app.event.QuizSubmittedEvent;

public class QuizSubmittedEventSerializer extends GenericSerializer<QuizSubmittedEvent> {
    public QuizSubmittedEventSerializer() {
        super(new TypeReference<QuizSubmittedEvent>(){});
    }
}
