package com.jdasilva.avaj.simulator;

import java.io.PrintWriter;

import com.jdasilva.avaj.exceptions.InvalidInputFormatException;

public class AircraftFactory 
{
    private static AircraftFactory instance = null;
    private static long idCounter = 1;

    private AircraftFactory(){}

    public static AircraftFactory getInstance()
    {
        if(instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates, PrintWriter p_writer) throws InvalidInputFormatException 
    {
        long id = idCounter++;
        String type = p_type.toLowerCase();
        switch(type) 
        {
            case "helicopter":
                return new Helicopter(id, p_name, p_coordinates, p_writer);
            case "jetplane":
                return new JetPlane(id, p_name, p_coordinates, p_writer);
            case "baloon":
                return new Baloon(id, p_name, p_coordinates, p_writer);
            default:
                throw new InvalidInputFormatException("Error: Invalid aircraft type.");
        }
    }
}
