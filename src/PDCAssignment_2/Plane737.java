/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

/**
 *
 * @author myles
 */
public class Plane737 extends Plane
{

    private Seat[][] seats;
    private final int rows = 8;
    private final int cols = 6;
    
    public Plane737()
    {
        super("Boeing 737");
        seats = new Seat[8][6];
        //method to set seat type
    }
    
    
    @Override
    public Plane getPlane() 
    {
        return this;
    }

    @Override
    public Seat[][] getSeats() 
    {
        return seats;
    }

    @Override
    public String getName() 
    {
        return this.name;
    }
    
    
    
}
