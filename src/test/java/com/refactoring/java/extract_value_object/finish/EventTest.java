package com.refactoring.java.extract_value_object.finish;

import com.refactoring.java.extract_value_object.finish.Event;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void should_not_create_event_without_name() {
        assertThatThrownBy(
                () -> Event.of(null, FROM_DATE, TO_DATE)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_not_create_event_without_fromDate() {
        assertThatThrownBy(
                () -> Event.of(EVENT_NAME, null, TO_DATE)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_not_create_event_without_toDate() {
        assertThatThrownBy(
                () -> Event.of(EVENT_NAME, FROM_DATE, null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_not_create_event_with_toDate_before_fromDate() {
        assertThatThrownBy(
                () -> Event.of(EVENT_NAME, TO_DATE, FROM_DATE)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private static final LocalDate FROM_DATE = LocalDate.of(2019, 11, 11);
    private static final LocalDate TO_DATE = LocalDate.of(2019, 11, 13);
    private static final String EVENT_NAME = "irrelevant";
}