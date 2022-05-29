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
public class Plane737SeatNumberTest {
    
    public Plane737SeatNumberTest() {
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

    /*
    Test to test getters of seats
    */
    
    @Test
    public void testSeatNumber()
    {
        Plane737 plane = new Plane737();
        int rows = plane.getRows();
        int cols = plane.getColumns();
        
        boolean expResult = true;
        
        boolean result = rows * cols == 20;
        
        assertEquals(expResult, result);
    }
    
    
}
