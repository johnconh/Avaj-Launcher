package com.jdasilva.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.jdasilva.avaj.exceptions.*;


public class Simulator 
{   
    public static void main(String[] args) 
    {
        try
        {
            if(args.length != 1)
                throw new InvalidInputFormatException();
            
        }catch (InvalidInputFormatException e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        String scenarioFile = args[0];

        try 
        {
            if(scenarioFile.isEmpty())
                throw new InvalidInputFormatException("Error: Scenario file is empty.");    
        } catch (InvalidInputFormatException e) 
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(scenarioFile)); 
            PrintWriter writer = new PrintWriter(new FileWriter("simulation.txt")))
        {
            if(!reader.ready())
            {
                System.out.println("Error: Scenario file is empty.");
                System.exit(1);
            }
            
            String line;
            int numOfSimulations = 0;
            WeatherTower weatherTower = new WeatherTower(writer);
            AircraftFactory factory = AircraftFactory.getInstance();

            try
            {
                numOfSimulations = Integer.parseInt(reader.readLine().trim());
                if (numOfSimulations <= 0)
                    throw new OutOfRangeException();
            }catch (OutOfRangeException e)
            {
                System.out.println(e.getMessage());
                System.exit(1);
            }catch (NumberFormatException e)
            {
                System.out.println("Error: Invalid number format for number of simulations.");
                System.exit(1);
            }

            while ((line = reader.readLine())!= null)
            {
                line = line.trim();
                if(line.isEmpty())
                    continue;
            
                String[] parts = line.split("\\s+");
                if (parts.length == 5)
                {
                    String type = parts[0];
                    String name = parts[1];
                    int longitude = 0;
                    int latitude = 0;
                    int height = 0;
                    try
                    {
                        longitude = Integer.parseInt(parts[2]);
                        latitude = Integer.parseInt(parts[3]);
                        height= Integer.parseInt(parts[4]);

                        if (longitude < 0 || latitude < 0 || height < 0)
                        {
                            throw new OutOfRangeException("Error: Coordinates must be non-negative.");
                        }

                        if (height > 100)
                        {
                            height = 100;
                        }

                    }catch (NumberFormatException e)
                    {
                        System.out.println("Error: Invalid number format in aircraft data.");
                        System.exit(1);
                    }catch (OutOfRangeException e)
                    {
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }

                    Coordinates coordinates = new  Coordinates(longitude, latitude, height);
                    Flyable aircraft = factory.newAircraft(type, name, coordinates, writer);
                    aircraft.registerTower(weatherTower);
                }
                else
                    System.out.println("Error: Incorrect data format for aircraft: " + line);
            }

            for (int i=0; i <  numOfSimulations; i++)
                weatherTower.changeWeather();
        } 
        catch (IOException e)
        {
            System.out.println("Error: Unable to read the file " + scenarioFile);
            System.exit(1);
        }
    }
}

