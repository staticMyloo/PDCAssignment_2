/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

/**
 *
 * @author myles
 */
public abstract class Plane 
{
    protected String name;
    
    public Plane(String name)
    {
        this.name = name;
    } 
    
    public abstract Plane getPlane();
    public abstract Seat[][] getSeats();
    public abstract String getName();
}
