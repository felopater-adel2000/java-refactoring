package com.refactoring.java.extract_value_object.finish;

class Assert {

    private Assert() {
    }

    static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}