/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

/**
 *
 * @author myles
 */
public class Receipt 
{
    String name;
    String passPort;
    String payment;
    String seat;
    Trip trip;
    int receiptNo;
    //private final String planeIcon = "<html>\u2708<html>";
    
    public Receipt(String name, String passPort, String payment, Trip trip, String seat, int receiptNo)
    {
        this.name = name;
        this.passPort = passPort;
        this.payment = payment;
        this.trip = trip;
        this.seat = seat;
        this.receiptNo = receiptNo;
    }
    
    @Override
    public String toString()
    {
        String out = "";
        out+= "+======================+"+"\n";
        out+= "User: "+name+"\n";
        out+= "Passport: "+passPort+"\n";
        out+= "Payment type: "+payment+"\n";
        out+= "Flight: "+trip.getOrigin()+" to "+trip.getDestination()+"\n";
        out+= "Cost: "+trip.getCost()+"\n";
        out+= "Date: "+trip.getTripDate()+"\n";
        out+= "Duration "+trip.getTripLength()+"\n";
        out+= "Seat: "+seat+"\n";
        out+= "Receipt Number: 0"+(receiptNo)+"\n";
        out+= "+======================+";
        return out;
    }
    
}
