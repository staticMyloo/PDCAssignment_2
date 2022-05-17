/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.util.Date;

/**
 *
 * @author myles
 */
public class Trip 
{
    private Plane plane;
    private String tripLength;
    private String time;
    private String date;
    private int cost;
    private String origin;
    private String destination;
   
 
    public Trip(String origin, String dest, Plane plane, String tripLength, String time, String date, int cost) 
    {
        this.origin = origin;
        this.destination = dest;
        this.plane = plane;
        this.tripLength = tripLength;
        this.time = time;
        this.date = date;
        this.cost = cost;
    }
    
    @Override
    public String toString()
    {
        return origin+" -> "+destination+"   "+tripLength+"   "+time+"   $"+cost+" "+date;
    }
    
    public boolean validateTrip(String origin, String destination, String time)
    {
        return this.origin.equals(origin) && this.destination.equals(destination) && this.time.equals(time);
    }
    
    public int getCost()
    {
        return this.cost;
    }
    
    public Trip getTrip()
    {
        return this;
    }
    
    public Plane getPlane()
    {
        return this.plane;
    }
    
    public String getTripDate()
    {
        return this.date;
    }
    
    public String getTime()
    {
        return this.time;
    }
    
    public String getTripLength()
    {
        return this.tripLength;
    }
    
    /**
     * @return the origin
     */
    public String getOrigin() 
    {
        return origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() 
    {
        return destination;
    }   
}
