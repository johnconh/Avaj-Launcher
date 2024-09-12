package com.jdasilva.avaj.exceptions;

public class OutOfRangeException extends Exception 
{
    private static final String d_message = "Error: Out of range";

    public OutOfRangeException() 
    {
        super(d_message);
    }
    
    public OutOfRangeException(String message) 
    {
        super(message);
    }
}
