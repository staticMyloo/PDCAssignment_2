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
    private final int rows = 6;
    private final int cols = 8;
    private final char letter;
    
    public Plane737()
    {
        super("Boeing 737");
        this.letter = 'A';
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
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return cols;
    }
    
}
