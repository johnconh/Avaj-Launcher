package com.jdasilva.avaj.simulator;

import java.io.PrintWriter;

public class WeatherTower  extends Tower
{
    public WeatherTower(PrintWriter writer)
    {
        super(writer);
    }

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        WeatherProvider.getInstance().randomFactor();
        conditionChanged();
    }

    @Override
    public void register(Flyable flyable) 
    {
        super.register(flyable);
    }

    @Override
    public void unregister(Flyable flyable) 
    {
        super.unregister(flyable);
    }
}
