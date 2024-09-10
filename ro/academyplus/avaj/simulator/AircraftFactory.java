package ro.academyplus.avaj.simulator;

import java.io.PrintWriter;

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

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates, PrintWriter p_writer) 
    {
        long id = idCounter++;
        switch(p_type) 
        {
            case "Helicopter":
                return new Helicopter(id, p_name, p_coordinates, p_writer);
            case "JetPlane":
                return new JetPlane(id, p_name, p_coordinates, p_writer);
            case "Baloon":
                return new Baloon(id, p_name, p_coordinates, p_writer);
            default:
                throw new IllegalArgumentException("Invalid type of aircraft");
        }
    }
}
