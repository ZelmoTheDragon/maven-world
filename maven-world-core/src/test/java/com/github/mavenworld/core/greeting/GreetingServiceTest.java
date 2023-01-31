package com.github.mavenworld.core.greeting;

import org.junit.jupiter.api.*;

class GreetingServiceTest {

    static GreetingRepository repository;

    static GreetingService underTest;

    GreetingServiceTest() {
    }

    @BeforeAll
    static void setUp() {
        repository = new GreetingRepository.InMemory();
        underTest = new GreetingService(repository);
    }

    @AfterAll
    static void tearDown() {
        // NO-OP
    }

    @BeforeEach
    void init() {
        // NO-OP
    }

    @AfterEach
    void dispose() {
        repository.clear();
    }

    @Test
    void shouldAddGreetingMessage() {
        var greetingMessage = new GreetingMessage("Hello world");
        var added = underTest.addGreetingMessage(greetingMessage);

        Assertions.assertTrue(added);
    }

    @Test
    void shouldNotAddDuplicateGreetingMessage() {
        var greetingMessage0 = new GreetingMessage("Hello world");
        var added0 = underTest.addGreetingMessage(greetingMessage0);

        var greetingMessage1 = new GreetingMessage("Hello world");
        var added1 = underTest.addGreetingMessage(greetingMessage1);

        var count = repository.size();

        Assertions.assertTrue(added0);
        Assertions.assertFalse(added1);
        Assertions.assertEquals(1, count);
    }

    @Test
    void shouldThrowExceptionForNullEntity() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> underTest.addGreetingMessage(null)
        );
    }

    @Test
    void shouldThrowExceptionForNullMessage() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> underTest.addGreetingMessage(new GreetingMessage(null))
        );
    }

    @Test
    void shouldThrowExceptionForBlackMessage() {
        Assertions.assertThrows(
                GreetingException.class,
                () -> underTest.addGreetingMessage(new GreetingMessage("   "))
        );
    }

}
