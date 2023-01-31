package com.github.mavenworld.core.greeting;

import java.util.Objects;

public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public boolean addGreetingMessage(final GreetingMessage greetingMessage) {
        validate(greetingMessage);
        return this.greetingRepository.add(greetingMessage);
    }

    private static void validate(final GreetingMessage entity) {
        Objects.requireNonNull(entity, "GreetingMessage can not be null");
        Objects.requireNonNull(entity.message(), "Message can not be null");
        if (entity.message().isBlank()) {
            throw new GreetingException("Message can not be blank");
        }
    }

}
