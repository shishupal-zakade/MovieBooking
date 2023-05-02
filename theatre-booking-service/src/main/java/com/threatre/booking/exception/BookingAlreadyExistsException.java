package com.threatre.booking.exception;
public class BookingAlreadyExistsException
    extends RuntimeException {
 
    private String message;
 
    public BookingAlreadyExistsException() {}
 
    public BookingAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}