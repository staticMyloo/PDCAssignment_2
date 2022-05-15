/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

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
    
    public Model()
    {
        this.db = new DataBaseManager();
    }
    
    
}
