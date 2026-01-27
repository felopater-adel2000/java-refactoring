package com.refactoring.java.extract_value_object.finish;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EventRepository {

    private final Map<String, Event> events = new HashMap<>();

    public void add(Event event) {
        Assert.notNull(event, "no event given");

        this.events.put(event.getName(), event);
    }

    public void removeOverlappingEvents(LocalDate date) {
        Assert.notNull(date, "date cannot be null");

        for (Event storedEvent : events.values()) {
            if (overlapsWith(date, storedEvent)) {
                events.remove(storedEvent.getName());
            }
        }
    }

    private boolean overlapsWith(LocalDate date, Event storedEvent) {
        return storedEvent.getFrom().isBefore(date) && storedEvent.getTo().isAfter(date)
                || storedEvent.getFrom().isEqual(date)
                || storedEvent.getTo().isEqual(date);
    }

    public Optional<Event> findByName(String name) {
        return Optional.ofNullable(events.get(name));
    }

    public int count() {
        return events.size();
    }

}