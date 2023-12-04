package com.quiz.app.event.listener;

import com.quiz.app.event.QuizSubmittedEvent;

public interface QuizSubmittedEventListener<R> extends DomainEventListener<QuizSubmittedEvent,R> {



}
