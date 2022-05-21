/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

/**
 *
 * @author myles
 */
public class SeatComponent extends JToggleButton
{
    ImageIcon icon;
    Seat seat;
    String text;
    BorderLayout layout;
    
    
    public SeatComponent(BorderLayout layout)
    {
       super();
       UIManager.put("ToggleButton.select", Color.BLUE);
       this.layout = layout;
       icon = new ImageIcon("./resources/seat.png");
       Image img = icon.getImage();
       Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
       icon = new ImageIcon(newImg);
       this.setIcon(icon);
       this.seat = new SeatStruct();
       this.seat.setReserve(false);  
    }
    
    @Override
    public void setText(String text)
    {
        this.text = text;
    }
}

