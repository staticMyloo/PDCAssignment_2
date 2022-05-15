/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author myles
 */
public class Controller implements ActionListener
{
    public View view;
    //public Model model;
    
    public Controller(View view)
    {
        //JFrame frame = new JFrame("Booking System");
        this.view = view;
        this.view.addActionListener(this);
        
        
    }
    
@Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        switch(command)
        {
            case "OK" -> view.addFlightSelectorPanel();
            case "Delete" -> System.out.println("delete");
            default -> {}
               
        }        
    }
    
    public static void main(String[] args) 
    {
        View view = new View();
        Controller con = new Controller(view);
    }
}
