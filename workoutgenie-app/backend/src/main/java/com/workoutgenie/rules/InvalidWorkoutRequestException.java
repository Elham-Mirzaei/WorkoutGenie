package com.workoutgenie.rules;

public class InvalidWorkoutRequestException extends RuntimeException {
    public InvalidWorkoutRequestException(String message) {
        super(message);
    }
}
