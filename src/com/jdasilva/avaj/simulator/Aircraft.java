package com.jdasilva.avaj.simulator;

import java.io.PrintWriter;

public class Aircraft extends Flyable
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String message = "";
    protected boolean hasLanded = false;
    protected PrintWriter writer;
    
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates, PrintWriter p_writer)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.writer = p_writer;
    }

    public void updateConditions(){};
    
    public boolean isLanded() 
    {
        return hasLanded;
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
