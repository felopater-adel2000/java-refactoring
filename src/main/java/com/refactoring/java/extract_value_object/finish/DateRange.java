package com.refactoring.java.extract_value_object.finish;

import java.time.LocalDate;

public class DateRange {
    LocalDate from;
    LocalDate to;

    private DateRange(LocalDate from, LocalDate to) {
        Assert.notNull(from, "from date cannot be null");
        Assert.notNull(to, "to date cannot be null");

        if (to.isBefore(from)) {
            throw new IllegalArgumentException("to date before from date");
        }

        this.from = from;
        this.to = to;
    }

    public static DateRange createDateRange(LocalDate from, LocalDate to) {
        return new DateRange(from, to);
    }

    boolean overlapsWith(LocalDate date) {
        if (from.isBefore(date) && to.isAfter(date)) return true;
        return from.isEqual(date) || to.isEqual(date);
    }
}