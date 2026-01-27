package com.refactoring.java.extract_value_object.finish;

import java.time.LocalDate;

public class DateRange {
    LocalDate from;
    LocalDate to;

    public DateRange() {
    }

    public static DateRange createDateRange(LocalDate from, LocalDate to) {
        Assert.notNull(from, "from date cannot be null");
        Assert.notNull(to, "to date cannot be null");

        if (to.isBefore(from)) {
            throw new IllegalArgumentException("to date before from date");
        }

        DateRange dateRange = new DateRange();
        dateRange.from = from;
        dateRange.to = to;
        return dateRange;
    }

    boolean overlapsWith(LocalDate date) {
        if (from.isBefore(date) && to.isAfter(date)) return true;
        return from.isEqual(date) || to.isEqual(date);
    }
}