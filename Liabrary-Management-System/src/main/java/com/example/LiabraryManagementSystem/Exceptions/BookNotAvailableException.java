package com.example.LiabraryManagementSystem.Exceptions;

public class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message) {
        super(message);
    }
}
