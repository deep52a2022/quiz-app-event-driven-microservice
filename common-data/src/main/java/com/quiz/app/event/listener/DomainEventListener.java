package com.quiz.app.event.listener;


import com.quiz.app.event.DomainEvent;

public interface DomainEventListener<T extends DomainEvent, R> {
    R processEvent(T domainEvent);
}

