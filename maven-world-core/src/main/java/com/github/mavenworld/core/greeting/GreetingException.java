package com.github.mavenworld.core.greeting;

import java.io.Serial;

class GreetingException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    GreetingException(String message) {
        super(message);
    }
}
