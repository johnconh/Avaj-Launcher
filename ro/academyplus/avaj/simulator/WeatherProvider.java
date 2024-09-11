package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.aircrafts.Coordinates;

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
        int index = Math.abs((coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length);
        return weather[index];
    }
}
