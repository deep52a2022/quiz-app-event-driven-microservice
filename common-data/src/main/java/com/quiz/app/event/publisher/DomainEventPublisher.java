package com.quiz.app.event.publisher;


import com.quiz.app.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
