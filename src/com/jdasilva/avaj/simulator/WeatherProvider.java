package com.jdasilva.avaj.simulator;

import java.util.Random;

public class WeatherProvider 
{
    private static WeatherProvider instance;
    private static String[] weather = {"Rain", "Fog", "Sun", "Snow"};
    private Random random = new Random();
    private int randomFactor;

    private WeatherProvider(){}

    public static WeatherProvider getInstance()
    {
        if(instance == null)
            instance = new WeatherProvider();
        return instance;
    }

    public void randomFactor()
    {
        randomFactor = random.nextInt(11) - 5; // Random number between -5 and 5
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        int index = Math.abs((p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight() + randomFactor) % weather.length);
        return weather[index];
    }
}
