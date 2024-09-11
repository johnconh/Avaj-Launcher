package com.jdasilva.avaj.simulator;

public abstract class  Flyable
{
    protected WeatherTower weatherTower;

    public abstract void updateConditions();
    public abstract boolean isLanded();

    public void registerTower(WeatherTower p_Tower)
    {
        this.weatherTower = p_Tower;
        weatherTower.register(this);
    }
}
