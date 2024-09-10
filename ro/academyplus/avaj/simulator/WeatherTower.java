package ro.academyplus.avaj.simulator;

import java.io.PrintWriter;

public class WeatherTower  extends Tower
{
    private static WeatherTower instance;
    
    public WeatherTower(PrintWriter writer)
    {
        super(writer);
    }

    public static WeatherTower getInstance(PrintWriter writer) {
        if (instance == null) {
            instance = new WeatherTower(writer);
        }
        return instance;
    }

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
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

    public PrintWriter getWriter() 
    {
        return writer;
    }
}
