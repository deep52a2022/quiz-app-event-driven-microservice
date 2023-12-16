package com.quiz.app.event.listener;

import com.quiz.app.event.QuizCreatedEvent;

public interface QuizCreatedEventListener<R> extends DomainEventListener<QuizCreatedEvent, R> {



}
