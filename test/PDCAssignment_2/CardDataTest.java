/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package PDCAssignment_2;

import java.util.Random;
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
        Random rand = new Random();
        CardData instance = new CardData();
        //testing for 6 digit match only. compare to regex pattern.
        boolean expResult = true;
        String pattern = ("^[0-9]{6}$");
        //generate 10 random test cases for card number match
        for(int i = 0; i < 10; i++)
        {
            Integer randomInt = Math.abs(rand.nextInt() % 999999);
            String formattedString = String.format("%06d", randomInt);
            instance.setCardNumber(formattedString);
            System.out.println(String.format("%06d", randomInt));
            boolean result = instance.cardMatch(instance.getCardNumber(), pattern);
            assertEquals(expResult, result);
        }
    }
    
    /**
     * Test of getCcvMatch method, of class CardData.
     */
    @Test
    public void testCardCCVMatch() {
        System.out.println("getCcvMatch");
        Random rand = new Random();
        CardData instance = new CardData();
        boolean expResult = true;
        String pattern = ("^[0-9]{3}$");
        
        for(int i = 0; i < 10; i++)
        {
            Integer randomInt = Math.abs(rand.nextInt() % 999);
            String formattedString = String.format("%03d", randomInt);
            instance.setCcvNumber(formattedString);
            System.out.println(String.format("%03d", randomInt));
            boolean result = instance.ccvMatch(instance.getCcvNumber(), pattern);
            assertEquals(expResult, result);
        }
        
    }
 

}
