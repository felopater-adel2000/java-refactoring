package com.refactoring.java.extract_value_object.finish;

import java.time.LocalDate;

public class Event {
    private final String name;
    private DateRange dateRange;

    public static Event of(String name, LocalDate from, LocalDate to) {
        return new Event(name, from, to);
    }

    private Event(String name, LocalDate from, LocalDate to) {
        Assert.notNull(name, "name cannot be null");
        this.name = name;

        this.dateRange = DateRange.of(from, to);
    }

    String getName() {
        return name;
    }

    boolean overlapsWith(LocalDate date) {
        return dateRange.overlapsWith(date);
    }
}