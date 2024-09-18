package com.jdasilva.avaj.simulator;

import java.io.PrintWriter;

public class JetPlane extends Aircraft
{
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates, PrintWriter p_Writer) 
    {
        super(p_id, p_name, p_coordinates, p_Writer);
    }
    
    @Override
    public void updateConditions() 
    {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        switch (weather) 
        {
            case "Sun":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                message = "Let's fly to the sun!";
                break;
            case "Rain":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                message = "It's raining. Better watch out for lightings.";
                break;
            case "Fog":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                message = "Who turned off the lights up here?";
                break;
            case "Snow":
                coordinates.setHeight(coordinates.getHeight() - 7);
                message = "OMG! Winter is coming!";
                break;
        }
        this.writer.println(this + ": " + message);
        if (coordinates.getHeight() <= 0) 
        {
            coordinates.setHeight(0);
            message = " landing.";
            hasLanded = true;
            this.writer.println(this + " " + message);
        }
    }
}
