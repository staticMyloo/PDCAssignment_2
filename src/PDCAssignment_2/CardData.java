/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

/**
 *
 * @author myles
 */
public class CardData 
{
    String cardNum;
    String ccv;
    String cardNumberMatch = ("^[0-9]{6}$");
    String CCVMatch = ("^[0-9]{3}$");
    
    
    public boolean cardMatch(String card, String pattern)
    {
        return card.matches(pattern);
    }
}
