package com.refactoring.java.extract_value_object.finish;

import java.time.LocalDate;

public class Event {
    private final String name;
    private final LocalDate from;
    private final LocalDate to;

    public static Event of(String name, LocalDate from, LocalDate to) {
        return new Event(name, from, to);
    }

    private Event(String name, LocalDate from, LocalDate to) {
        Assert.notNull(name, "name cannot be null");
        Assert.notNull(from, "from date cannot be null");
        Assert.notNull(to, "to date cannot be null");

        if (to.isBefore(from)) {
            throw new IllegalArgumentException("to date before from date");
        }

        this.name = name;
        this.from = from;
        this.to = to;
    }

    String getName() {
        return name;
    }

    LocalDate getFrom() {
        return from;
    }

    LocalDate getTo() {
        return to;
    }
}