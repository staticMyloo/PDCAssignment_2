/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author myles
 */
public class Controller implements ActionListener
{
    public View view;
    public Model model;
    
    public Controller(View view, Model model)
    {
        //JFrame frame = new JFrame("Booking System");
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
@Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        switch(command)
        {
            case "Login":
                String user = view.userField.getText();
                String password = view.passWordField.getText();
                String passport = view.passPortField.getText();
                System.out.println(user+" "+password+" "+passport);
                this.model.checkName(user, password, passport);
                if(this.model.data.loginFlag)
                {
                    this.view.addFlightSelectorPanel();
                  
                }
                else
                {
                    view.passWordField.setText("INVALID PASSWORD");
                }
                this.view.repaint();
                this.view.revalidate();
                System.out.println("login pressed");
                break;
            case "Show Flights":
                System.out.println("showing flights");
                //pass in model method to get flights
                String origin = (String) view.getOriginBox().getSelectedItem();
                String destination = (String) view.getDestBox().getSelectedItem();
                String time = view.bg.getSelection().getActionCommand();
                ArrayList<Trip> trips = model.db.getSelectedFlights(origin, destination, time);
                view.updateFlightList(trips);
                break;
            case  "OK":
                System.out.println("ok");
                Trip temp = (Trip) view.flightList.getSelectedValue();
                model.setSelectedTrip(temp);
                System.out.println("Your trip is "+temp);
                if(model.selectedTrip != null)
                {
                    view.addSeatSelectorPanel();
                    this.view.getUserInfoLabel().setText("User: "+model.user);
                    this.view.getFlightInfoLabel().setText(temp.toViewFlightString());
                }
                break;
            case "Delete":
                System.out.println("delete");
                break;
            default:
                break;    
        }
    }
    
    public static void main(String[] args) throws ParseException 
    {
        View view = new View();
        Model model = new Model();
        Controller con = new Controller(view, model);
    }
}
