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
public class CardDataTest {
    
    public CardDataTest() {
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
     * Test of cardMatch method, of class CardData.
     */
    @Test
    public void testCardNumberMatch() {
        System.out.println("cardMatch");
        CardData instance = new CardData();
        //testing for 6 digit match only. compare to regex pattern.
        instance.setCardNumber("002003");
        boolean expResult = true;
        String pattern = ("^[0-9]{6}$");
        boolean result = instance.cardMatch(instance.getCardNumber(), pattern);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCcvMatch method, of class CardData.
     */
    @Test
    public void testCardCCVMatch() {
        System.out.println("getCcvMatch");
        CardData instance = new CardData();
        //testing for 3 digit match only. compare to regex pattern.
        instance.setCcvNumber("123");
        String pattern = ("^[0-9]{3}$");
        boolean expResult = true;
        boolean result = instance.cardMatch(instance.getCcvNumber(), pattern);
        assertEquals(expResult, result);
    }
 

}
