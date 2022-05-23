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
    String cardNumberMatch;
    String CCVMatch;
    
    public CardData()
    {
        cardNum = null;
        ccv = null;
        cardNumberMatch = ("^[0-9]{6}$");
        CCVMatch = ("^[0-9]{3}$");
        
    }
    
    public boolean cardMatch(String card, String pattern)
    {
        return card.matches(pattern);
    }
    
    public String getNumberMatch()
    {
        return this.cardNumberMatch;
    }
    
    public String getCcvMatch()
    {
        return this.CCVMatch;
    }
    
    public String getCardNumber()
    {
        return this.cardNum;
    }
    
    public String getCcvNumber()
    {
        return this.ccv;
    }
    
    public void setCardNumber(String number)
    {
        this.cardNum = number;
    }
    
    public void setCcvNumber(String ccv)
    {
        this.ccv = ccv;
    }
}
