package com.refactoring.java.extract_value_object.finish;

import java.time.LocalDate;

public class DateRange {
    LocalDate from;
    LocalDate to;

    public DateRange() {
    }

    boolean overlapsWith(LocalDate date) {
        if (from.isBefore(date) && to.isAfter(date)) return true;
        return from.isEqual(date) || to.isEqual(date);
    }
}