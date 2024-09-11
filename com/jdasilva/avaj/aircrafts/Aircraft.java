package com.jdasilva.avaj.aircrafts;

import java.io.PrintWriter;

import com.jdasilva.avaj.simulator.Flyable;

public abstract class Aircraft extends Flyable
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String message = "";
    protected boolean hasLanded = false;
    protected PrintWriter writer;

    public abstract void updateConditions();

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates, PrintWriter p_writer)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.writer = p_writer;
    }

    public boolean isLanded() 
    {
        return hasLanded;
    }
    
    public String getMessage()
    {
        return message;
    }

    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }   

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }
}
