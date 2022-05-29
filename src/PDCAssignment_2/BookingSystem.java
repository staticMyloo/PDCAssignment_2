/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.text.ParseException;

/**
 *
 * @author myles
 */
public class BookingSystem 
{
    private final Controller controller;
    
    public BookingSystem() throws ParseException
    {
        this.controller = new Controller();
    }
    
    public static void main(String[] args) throws ParseException 
    {
        Controller controller = new Controller();
    }
    
}
