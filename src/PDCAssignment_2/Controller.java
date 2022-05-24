/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author myles
 */
public class Controller implements ActionListener, ItemListener
{
    public View view;
    public Model model;
    
    
    public Controller(View view, Model model)
    {
        UIManager.put("ToggleButton.select", Color.BLUE);
        //JFrame frame = new JFrame("Booking System");
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
@Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch (command) {
            case "Login":
                String user = view.userField.getText();
                String password = view.passWordField.getText();
                String passport = view.passPortField.getText();
                System.out.println(user + " " + password + " " + passport);
                this.model.checkName(user, password, passport);
                if (this.model.data.loginFlag) {
                    model.data.userName = user;
                    model.data.passWord = password;
                    model.data.passPortNo = passport;
                    this.view.addFlightSelectorPanel();
                } else {
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
            case "OK":
                System.out.println("ok");
                Trip temp = (Trip) view.flightList.getSelectedValue();
                view.cardPanel.setVisible(false);
                if (temp != null) {
                    model.setSelectedTrip(temp);
                    System.out.println("Your trip is " + temp);
                    System.out.println("your plane is " + temp.getPlane().toString());
                    if (model.selectedTrip != null) {
                        model.db.selectedTrip = temp;
                        view.addSeatSelectorPanel();
                        this.view.getUserInfoLabel().setText("User: " + model.data.userName);
                        this.view.getFlightInfoLabel().setText("Flight: " + temp.toViewFlightString());
                        this.view.setSeats(temp);
                        this.view.addSeatItemListener(this, temp);
                    }
                }
                break;
            case "Go back":
                //temp = null;
                System.out.println(model.data.userName);
                System.out.println(model.data.passPortNo);
                //model.selectedTrip = null;
                this.view.reAddFlightSelectorPanel();
                break;
            case "Confirm":
                System.out.println("confirm");
                String selectedSeat = this.view.seatGroup.getSelection().getActionCommand();
                model.data.seat = selectedSeat;
                System.out.println(selectedSeat);
                if(!this.view.cardPanel.isVisible())
                {
                    System.out.println(model.data.userName);
                    System.out.println(model.data.passPortNo);
                    this.view.addCardPanel();
                }
                else if(this.view.payGroup.getSelection() != null)
                {
                    temp = (Trip) view.flightList.getSelectedValue();
                    System.out.println("paying select true");
                    String insertUser = model.data.userName;
                    String insertPass = model.data.passPortNo;
                    String insertOrigin = temp.getOrigin();
                    String insertDestination = temp.getDestination();
                    String insertPayment = this.view.payGroup.getSelection().getActionCommand();
                    //get customer info
                    //load into payment method 
                    try
                    {
                       System.out.println(insertUser+insertPass+insertOrigin+insertDestination+insertPayment);
                       model.data = model.db.insertPaymentInfo(insertUser, insertPass, insertOrigin, insertDestination, insertPayment); 
                       model.data.seat = selectedSeat;
                       model.data.payment = insertPayment;
                       System.out.println(model.data.paySelect);
                       if(model.data.paySelect && this.view.payGroup.getSelection() != null)
                       {
                           this.view.cardPanel.setVisible(false);
                           this.model.data.userName = insertUser;
                           this.model.data.passPortNo = insertPass;
                           System.out.println(model.data.userName+" "+model.data.passPortNo);
                           view.repaint();
                           view.revalidate();
                           this.view.addPayPanel();
                       }
                    }
                    catch(SQLException ex){}
                }
                break;
            case "Pay now":
                System.out.println("paying now");
                //read in card num from textField
                String cardInput = view.cardNumberField.getText();
                //read in card num from ccvField
                String ccvInput = view.ccvField.getText();
                //check if matches
                //update model.db.cardData into method
                model.cardData = new CardData();
                
                if(cardInput.matches(model.cardData.cardNumberMatch) && ccvInput.matches(model.cardData.CCVMatch))
                {
                    model.cardData = model.db.setCard(cardInput, ccvInput);
                    System.out.println(cardInput+" "+ccvInput);
                    System.out.println("congrats "+model.data.userName+model.data.passPortNo+" you are flying to "+model.selectedTrip.getOrigin()+" to "+model.selectedTrip.getDestination());
                    System.out.println("you paid via"+view.payGroup.getSelection().getActionCommand());
                    view.addPaySuccessPanel();
                    System.out.println(model.data.userName+" "+model.data.passPortNo+" "+this.view.payGroup.getSelection().getActionCommand()+" "+model.data.seat);
                    try {
                        model.db.insertPaymentReceiptInfo(model.data.userName, model.data.passPortNo, this.view.payGroup.getSelection().getActionCommand(), model.data.seat);
                    } catch (SQLException ex) {}
                    //use database to pull information from receipt table
                    //get userid, passport, payment, seat
                    //use model selectedTrip to get trip information
                    view.receiptPane.append((new Receipt(model.data.userName, model.data.passPortNo, model.data.payment, model.selectedTrip, model.data.seat)).toString());
                }
                break;
            case "Click to exit.":
                view.dispose();
                break;
            default:
                break;  
        }
        
    }
        
    @Override
    public void itemStateChanged(ItemEvent event)
    {
        int state = event.getStateChange();
        if(state == ItemEvent.SELECTED)
        {
            String seat = view.seatGroup.getSelection().getActionCommand();
            this.model.data.seat = seat;
            this.view.seatNumberLabel.setText("Seat:   "+seat+"    ");
        }
    }
    
    
    public static void main(String[] args) throws ParseException 
    {
        
        View view = new View();
        Model model = new Model();
        Controller con = new Controller(view, model);
    }
}
