/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

    public SeatComponent()
    {
       super();
       icon = new ImageIcon("./resources/seat.png");
       Image img = icon.getImage();
       Image newImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
       icon = new ImageIcon(newImg);
       this.setIcon(icon);
       this.seat = new SeatStruct();
       this.seat.setReserve(false);  
    }
    
    public static void main(String[] args) 
    {
        UIManager.put("ToggleButton.select", Color.RED);
       
        JFrame frame = new JFrame();
        SeatComponent seat = new SeatComponent();
        seat.setPreferredSize(new Dimension(60,60));
        seat.seat.setReserve(true);
        JPanel seatPanel = new JPanel();
        seatPanel.setPreferredSize(new Dimension(200,200));
        frame.setSize(300,300);
        seatPanel.add(seat);
        frame.add(seatPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
  
}

