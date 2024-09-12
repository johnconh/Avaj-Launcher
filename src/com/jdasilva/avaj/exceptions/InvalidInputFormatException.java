package com.jdasilva.avaj.exceptions;

public class InvalidInputFormatException extends Exception 
{
    private static final String d_message = "Error: Invalid input format";

    public InvalidInputFormatException() 
    {
        super(d_message);
    }

    public InvalidInputFormatException(String message) 
    {
        super(message);
    }
}
