package com.interview.exceptions;

public class SongAlreadyExistsException extends RuntimeException {

    public SongAlreadyExistsException(String message) {
        super(message);
    }

}
