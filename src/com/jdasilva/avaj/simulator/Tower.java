package com.jdasilva.avaj.simulator;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Tower 
{
    private List<Flyable> observers = new ArrayList<>();
    protected PrintWriter writer;

    public Tower(PrintWriter p_writer)
    {
        this.writer = p_writer;
    }

    public void register(Flyable p_flyable)
    {
        observers.add(p_flyable);
        writer.println("Tower says: " + p_flyable.toString() + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable)
    {
        observers.remove(p_flyable);
        writer.println("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }

    protected void conditionChanged()
    {
        Iterator<Flyable> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Flyable flyable = iterator.next();
            flyable.updateConditions();
            if (flyable.isLanded()) {
                iterator.remove();
                unregister(flyable);
            }
        }
    }
}
