/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author myles
 */
public class Model extends Observable
{
    //public trip
    //public customer
    //public 
    public DataBaseManager db;
    public Data data;
    public String user;
    public String origin, destination, time;
    public Trip selectedTrip;
    
    
    public Model()
    {
        this.db = new DataBaseManager();
    }
    
    public void checkName(String username, String password, String passport)
    {
        this.user = username;
        this.data = this.db.checkUser(username, password, passport);
        this.setChanged();
        this.notifyObservers(this.data); 
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
