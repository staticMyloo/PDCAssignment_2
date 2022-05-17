/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.util.ArrayList;
/**
 *
 * @author myles
 */
public class TripList
{
    private final ArrayList<Trip> list;
    
    public TripList()
    {
        this.list = new ArrayList<>();
        //String origin, String dest, Plane plane, String tripLength, String time, String date, float cost
        
        //data for trips
        Trip AKLtoWEL = new Trip("AKL", "WEL", new Plane737(), "2h", "10:00", "10/06/2022", 450);
        Trip AKLtoWEL2 = new Trip("AKL", "WEL", new Plane737(), "2h", "10:00", "11/06/2022", 450);
        Trip AKLtoWEL3 = new Trip("AKL", "WEL", new Plane737(), "2h", "10:00", "12/06/2022", 450);
        Trip AKLtoWEL4 = new Trip("AKL", "WEL", new Plane737(), "2h", "12:30", "13/06/2022", 450);
        Trip AKLtoWEL5 = new Trip("AKL", "WEL", new Plane737(), "2h", "12:30", "10/06/2022", 450);
        Trip AKLtoWEL6 = new Trip("AKL", "WEL", new Plane737(), "2h", "12:30", "12/06/2022", 450);
        Trip AKLtoWEL7 = new Trip("AKL", "WEL", new Plane737(), "2h", "16:00", "13/06/2022", 450);
        Trip AKLtoWEL8 = new Trip("AKL", "WEL", new Plane737(), "2h", "16:00", "12/06/2022", 450);
        Trip AKLtoWEL9 = new Trip("AKL", "WEL", new Plane737(), "2h", "16:00", "11/06/2022", 450);
        Trip AKLtoWEL10 = new Trip("AKL", "WEL", new Plane737(), "2h", "19:00", "11/06/2022", 450);
        Trip AKLtoWEL11 = new Trip("AKL", "WEL", new Plane737(), "2h", "19:00", "12/06/2022", 450);
        Trip AKLtoWEL12 = new Trip("AKL", "WEL", new Plane737(), "2h", "19:00", "10/06/2022", 450);
        
        
        Trip AKLtoCHCH = new Trip("AKL", "CHCH", new Plane737(), "3h", "10:00", "10/06/2022", 600);
        Trip AKLtoCHCH2 = new Trip("AKL", "CHCH", new Plane737(), "3h", "10:00", "12/06/2022", 600);
        Trip AKLtoCHCH3 = new Trip("AKL", "CHCH", new Plane737(), "3h", "10:00", "11/06/2022", 600);
        Trip AKLtoCHCH4 = new Trip("AKL", "CHCH", new Plane737(), "3h", "12:30", "10/06/2022", 600);
        Trip AKLtoCHCH5 = new Trip("AKL", "CHCH", new Plane737(), "3h", "12:30", "11/06/2022", 600);
        Trip AKLtoCHCH6 = new Trip("AKL", "CHCH", new Plane737(), "3h", "12:30", "12/06/2022", 600);
        Trip AKLtoCHCH7 = new Trip("AKL", "CHCH", new Plane737(), "3h", "16:00", "10/06/2022", 600);
        Trip AKLtoCHCH8 = new Trip("AKL", "CHCH", new Plane737(), "3h", "16:00", "11/06/2022", 600);
        Trip AKLtoCHCH9 = new Trip("AKL", "CHCH", new Plane737(), "3h", "16:00", "12/06/2022", 600);
        Trip AKLtoCHCH10 = new Trip("AKL", "CHCH", new Plane737(), "3h", "19:00", "10/06/2022", 600);
        Trip AKLtoCHCH11 = new Trip("AKL", "CHCH", new Plane737(), "3h", "19:00", "11/06/2022", 600);
        Trip AKLtoCHCH12 = new Trip("AKL", "CHCH", new Plane737(), "3h", "19:00", "12/06/2022", 600);
        
        
        Trip WELtoAKL = new Trip("WEL", "AKL", new Plane737(), "2h", "10:00", "10/06/2022", 450);
        Trip WELtoAKL2 = new Trip("WEL", "AKL", new Plane737(), "2h", "10:00", "12/06/2022", 450);
        Trip WELtoAKL3 = new Trip("WEL", "AKL", new Plane737(), "2h", "10:00", "13/06/2022", 450);
        Trip WELtoAKL4 = new Trip("WEL", "AKL", new Plane737(), "2h", "12:30", "11/06/2022", 450);
        Trip WELtoAKL5 = new Trip("WEL", "AKL", new Plane737(), "2h", "12:30", "12/06/2022", 450);
        Trip WELtoAKL6 = new Trip("WEL", "AKL", new Plane737(), "2h", "12:30", "14/06/2022", 450);
        Trip WELtoAKL7 = new Trip("WEL", "AKL", new Plane737(), "2h", "16:00", "11/06/2022", 450);
        Trip WELtoAKL8 = new Trip("WEL", "AKL", new Plane737(), "2h", "16:00", "12/06/2022", 450);
        Trip WELtoAKL9 = new Trip("WEL", "AKL", new Plane737(), "2h", "16:00", "10/06/2022", 450);
        Trip WELtoAKL10 = new Trip("WEL", "AKL", new Plane737(), "2h", "19:00", "11/06/2022", 450);
        Trip WELtoAKL11 = new Trip("WEL", "AKL", new Plane737(), "2h", "19:00", "12/06/2022", 450);
        Trip WELtoAKL12 = new Trip("WEL", "AKL", new Plane737(), "2h", "19:00", "13/06/2022", 450);
        
        Trip WELtoCHCH = new Trip("WEL", "CHCH", new Plane737(), "1h30", "10:00", "11/06/2022", 390);
        Trip WELtoCHCH2 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "10:00", "12/06/2022", 390);
        Trip WELtoCHCH3 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "10:00", "13/06/2022", 390);
        Trip WELtoCHCH4 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "12:30", "12/06/2022", 390);
        Trip WELtoCHCH5 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "12:30", "13/06/2022", 390);
        Trip WELtoCHCH6 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "12:30", "14/06/2022", 390);
        Trip WELtoCHCH7 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "16:00", "10/06/2022", 390);
        Trip WELtoCHCH8 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "16:00", "12/06/2022", 390);
        Trip WELtoCHCH9 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "16:00", "13/06/2022", 390);
        Trip WELtoCHCH10 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "19:00", "11/06/2022", 390);
        Trip WELtoCHCH11 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "19:00", "12/06/2022", 390);
        Trip WELtoCHCH12 = new Trip("WEL", "CHCH", new Plane737(), "1h30", "19:00", "13/06/2022", 390);
        
        Trip CHCHtoAKL = new Trip("CHCH", "AKL", new Plane737(), "3h", "10:00", "10/06/2022", 600);
        Trip CHCHtoAKL2 = new Trip("CHCH", "AKL", new Plane737(), "3h", "10:00", "11/06/2022", 600);
        Trip CHCHtoAKL3 = new Trip("CHCH", "AKL", new Plane737(), "3h", "10:00", "12/06/2022", 600);
        Trip CHCHtoAKL4 = new Trip("CHCH", "AKL", new Plane737(), "3h", "12:30", "10/06/2022", 600);
        Trip CHCHtoAKL5 = new Trip("CHCH", "AKL", new Plane737(), "3h", "12:30", "11/06/2022", 600);
        Trip CHCHtoAKL6 = new Trip("CHCH", "AKL", new Plane737(), "3h", "12:30", "12/06/2022", 600);
        Trip CHCHtoAKL7 = new Trip("CHCH", "AKL", new Plane737(), "3h", "16:00", "10/06/2022", 600);
        Trip CHCHtoAKL8 = new Trip("CHCH", "AKL", new Plane737(), "3h", "16:00", "11/06/2022", 600);
        Trip CHCHtoAKL9 = new Trip("CHCH", "AKL", new Plane737(), "3h", "16:00", "12/06/2022", 600);
        Trip CHCHtoAKL10 = new Trip("CHCH", "AKL", new Plane737(), "3h", "19:00", "10/06/2022", 600);
        Trip CHCHtoAKL11 = new Trip("CHCH", "AKL", new Plane737(), "3h", "19:00", "11/06/2022", 600);
        Trip CHCHtoAKL12 = new Trip("CHCH", "AKL", new Plane737(), "3h", "19:00", "12/06/2022", 600);
        
        Trip CHCHtoWEL = new Trip("CHCH", "WEL", new Plane737(), "1h30", "10:00", "10/06/2022", 390);
        Trip CHCHtoWEL2 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "10:00", "11/06/2022", 390);
        Trip CHCHtoWEL3 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "10:00", "12/06/2022", 390);
        Trip CHCHtoWEL4 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "12:30", "12/06/2022", 390);
        Trip CHCHtoWEL5 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "12:30", "13/06/2022", 390);
        Trip CHCHtoWEL6 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "12:30", "14/06/2022", 390);
        Trip CHCHtoWEL7 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "16:00", "10/06/2022", 390);
        Trip CHCHtoWEL8 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "16:00", "12/06/2022", 390);
        Trip CHCHtoWEL9 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "16:00", "13/06/2022", 390);
        Trip CHCHtoWEL10 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "19:00", "11/06/2022", 390);
        Trip CHCHtoWEL11 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "19:00", "12/06/2022", 390);
        Trip CHCHtoWEL12 = new Trip("CHCH", "WEL", new Plane737(), "1h30", "19:00", "13/06/2022", 390);
        
        list.add(AKLtoWEL);list.add(AKLtoWEL2);list.add(AKLtoWEL3);list.add(AKLtoWEL4);list.add(AKLtoWEL5);
        list.add(AKLtoWEL6);list.add(AKLtoWEL7);list.add(AKLtoWEL8);list.add(AKLtoWEL9);list.add(AKLtoWEL10);
        list.add(AKLtoWEL11);list.add(AKLtoWEL12);
        list.add(AKLtoCHCH);list.add(AKLtoCHCH2);list.add(AKLtoCHCH3);list.add(AKLtoCHCH4);list.add(AKLtoCHCH5);
        list.add(AKLtoCHCH6);list.add(AKLtoCHCH7);list.add(AKLtoCHCH8);list.add(AKLtoCHCH9);list.add(AKLtoCHCH10);
        list.add(AKLtoCHCH11);list.add(AKLtoCHCH12);
        list.add(WELtoAKL);list.add(WELtoAKL2);list.add(WELtoAKL3);list.add(WELtoAKL4);list.add(WELtoAKL5);
        list.add(WELtoAKL6);list.add(WELtoAKL7);list.add(WELtoAKL8);list.add(WELtoAKL9);list.add(WELtoAKL10);
        list.add(WELtoAKL11);list.add(WELtoAKL12);
        list.add(WELtoCHCH);list.add(WELtoCHCH2);list.add(WELtoCHCH3);list.add(WELtoCHCH4);list.add(WELtoCHCH5);
        list.add(WELtoCHCH6);list.add(WELtoCHCH7);list.add(WELtoCHCH8);list.add(WELtoCHCH9);list.add(WELtoCHCH10);
        list.add(WELtoCHCH11);list.add(WELtoCHCH12);
        list.add(CHCHtoAKL);list.add(CHCHtoAKL2);list.add(CHCHtoAKL3);list.add(CHCHtoAKL4);list.add(CHCHtoAKL5);
        list.add(CHCHtoAKL6);list.add(CHCHtoAKL7);list.add(CHCHtoAKL8);list.add(CHCHtoAKL9);list.add(CHCHtoAKL10);
        list.add(CHCHtoAKL11);list.add(CHCHtoAKL12);
        list.add(CHCHtoWEL);list.add(CHCHtoWEL2);list.add(CHCHtoWEL3);list.add(CHCHtoWEL4);list.add(CHCHtoWEL5);
        list.add(CHCHtoWEL6);list.add(CHCHtoWEL7);list.add(CHCHtoWEL8);list.add(CHCHtoWEL9);list.add(CHCHtoWEL10);
        list.add(CHCHtoWEL11);list.add(CHCHtoWEL12);
    }

    public ArrayList getTripList()
    {
        return this.list;
    }
    
    public TripList(ArrayList tripList)
    {
        this.list = tripList;
    }
    
    
    
    
    
}
