package com.jdasilva.avaj.simulator;

import java.util.Random;

public class WeatherProvider 
{
    private static WeatherProvider instance;
    private static String[] weather = {"Rain", "Fog", "Sun", "Snow"};

    private WeatherProvider(){}

    public static WeatherProvider getInstance()
    {
        if(instance == null)
            instance = new WeatherProvider();
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        Random random = new Random();

        int randomFactor = random.nextInt(11) - 5; // Random number between -5 and 5
        int index = Math.abs((coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() + randomFactor) % weather.length);
        return weather[index];
    }
}
