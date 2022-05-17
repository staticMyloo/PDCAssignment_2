/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

/**
 *
 * @author myles
 */
public abstract class Seat 
{
    private boolean reserve;
    public SeatType type;
    
    public Seat()
    {
        this.reserve = false;
        this.type = SeatType.Economy;
    }
    
    public Seat getSeat()
    {
        return this;
    }

    /**
     * @param reserve the reserve to set
     */
    public void setReserve(boolean reserve) 
    {
        this.reserve = reserve;
    }

    /**
     * @return the reserve
     */
    public boolean isReserve() 
    {
        return reserve;
    }
    
    
}
