package com.example.crm.infrastructure;

public interface EventPublisher<T> {
	void publishEvent(T event);
}
