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

    private SeatComponent[][] seats;
    private final int rows = 4;
    private final int cols = 5;
    private final char letter;
    
    public Plane737()
    {
        super("Boeing 737");
        this.letter = 'A';
        
        seats = new SeatComponent[rows][cols];
       
        //method to set seat type
    }
    
    @Override
    public String toString()
    {
        String out = "";
        
        return out;
    }
    
    @Override
    public Plane737 getPlane() 
    {
        return this;
    }

    public SeatComponent[][] getSeatComps()
    {
        return seats;
    }
    
  
    @Override
    public String getName() 
    {
        return this.name;
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return cols;
    }

    @Override
    public Seat[][] getSeats() 
    {
        return null;
    }
    
}
