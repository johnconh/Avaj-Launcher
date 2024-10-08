package com.jdasilva.avaj.simulator;

import java.io.PrintWriter;

public class WeatherTower  extends Tower
{
    public WeatherTower(PrintWriter p_writer)
    {
        super(p_writer);
    }

    public void changeWeather()
    {
        WeatherProvider.getInstance().randomFactor();
        conditionChanged();
    }

    public String getWeather(Coordinates p_coordinates)
    {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    @Override
    public void register(Flyable p_flyable) 
    {
        super.register(p_flyable);
    }

    @Override
    public void unregister(Flyable p_flyable) 
    {
        super.unregister(p_flyable);
    }
}
