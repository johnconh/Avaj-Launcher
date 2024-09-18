package com.jdasilva.avaj.simulator;

import java.io.PrintWriter;

public class Helicopter extends Aircraft
{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates, PrintWriter p_writer) 
    {
        super(p_id, p_name, p_coordinates, p_writer);
    }   

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        switch (weather) 
        {
            case "Sun":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                message = "This is hot.";
                break;
            case "Rain":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                message = "I'm getting wet.";
                break;
            case "Fog":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                message = "I can't see anything in this fog.";
                break;
            case "Snow":
                coordinates.setHeight(coordinates.getHeight() - 12);
                message = "My rotor is going to freeze!.";
                break;
        }
        writer.println(this + ": " + message);
        if (coordinates.getHeight() <= 0) 
        {
            coordinates.setHeight(0);
            message = "landing.";
            hasLanded = true;
            writer.println(this + " " + message);
        }
    }
}
