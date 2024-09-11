package com.jdasilva.avaj.aircrafts;

import java.io.PrintWriter; // Import the PrintWriter class

import com.jdasilva.avaj.simulator.WeatherProvider;

public class Baloon extends Aircraft 
{
    public Baloon(long p_id, String p_name, Coordinates p_coordinates, PrintWriter p_writer)
    {
        super(p_id, p_name, p_coordinates, p_writer);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        switch (weather) 
        {
            case "Sun":
                coordinates.setHeight(coordinates.getHeight() + 4);
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                message = "Let's enjoy the good weather and take some pics";
                break;
            case "Rain":
                coordinates.setHeight(coordinates.getHeight() - 5);
                message = "Damn you rain! You messed up my baloon.";
                break;
            case "Fog":
                    coordinates.setHeight(coordinates.getHeight() - 3);
                    message = "I feel like a cloud in the fog! Where is the sun when you need it?’.";
                    break;
            case "Snow":
                coordinates.setHeight(coordinates.getHeight() - 15);
                message = "It's snowing. We're gonna crash.";
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
