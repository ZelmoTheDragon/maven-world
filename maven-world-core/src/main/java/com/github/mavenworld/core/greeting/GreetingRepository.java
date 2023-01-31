package com.github.mavenworld.core.greeting;

import java.util.HashSet;
import java.util.Set;

public interface GreetingRepository {
    boolean add(GreetingMessage entity);

    void clear();

    int size();


    class InMemory implements GreetingRepository {

        private final Set<GreetingMessage> database;

        public InMemory() {
            this.database = new HashSet<>();
        }

        @Override
        public boolean add(GreetingMessage entity) {
            return this.database.add(entity);
        }

        @Override
        public void clear() {
            this.database.clear();
        }

        @Override
        public int size() {
            return this.database.size();
        }


    }
}
