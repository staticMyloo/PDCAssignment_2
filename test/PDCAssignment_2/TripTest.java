/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package PDCAssignment_2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myles
 */
public class TripTest {
    
    public TripTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    

    /**
     * Test of toViewFlightString method, of class Trip.
     */
    @Test
    public void testToViewFlightString() {
        System.out.println("toViewFlightString");
        Trip instance = new Trip("AKL", "WEL", new Plane737(), "2h", "10:00", "10/06/2022", 450);
        String expResult = "AKL"+" -> "+"WEL"+"   "+"2h"+"   "+"10:00"+" "+"10/06/2022";
        //testing for correct output in GUI display when selecting a trip. 
        String result = instance.toViewFlightString();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateTrip method, of class Trip.
     */
    @Test
    public void testValidateTrip() {
        System.out.println("validateTrip");
        Trip instance = new Trip("AKL", "WEL", new Plane737(), "2h", "16:00", "13/06/2022", 450);
        boolean expResult = true;
        boolean result = instance.validateTrip("AKL", "WEL", "16:00");
        //testing for trip validation against database look up
        assertEquals(expResult, result);
    }


}
