/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author myles
 */
public class Model extends Observable
{
    public DataBaseManager db;
    public Data data;
    public CardData cardData;
    public String user;
    public String origin, destination, time, seat, passport;
    public Trip selectedTrip;
    public String seatSelection;
    
    
    public Model()
    {
        this.db = new DataBaseManager();
    }
    
    
    
    
    public void checkName(String username, String password, String passport)
    {
        this.user = username;
        this.data = this.db.checkUser(username, password, passport);
        data.userName = username;
        data.passPortNo = passport;
        data.passWord = password;
        this.setChanged();
        this.notifyObservers(this.data); 
    }
    
    public void insertPaymentInfo(String user, String passport, String origin, String destination, String payment) throws SQLException
    {
        this.data = db.insertPaymentInfo(user, passport, origin, destination, payment);
        this.data.userName = user;
        this.data.passPortNo = passport;
        this.setChanged();
        this.notifyObservers(this.data);
        this.data.paySelect = true;
    }
    
    public void getSelectedFlightOptions()
    {
        db.getSelectedFlights(origin, user, time);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setSelectedTrip(Trip trip)
    {
        this.selectedTrip = trip;
    }
    
    
}
