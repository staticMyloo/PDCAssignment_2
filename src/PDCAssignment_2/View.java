/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author myles
 */
public class View extends JPanel
{
    
    private JPanel originPanel;
    private JComboBox originBox;
    private JLabel originLabel;
    private JPanel destPanel;
    private JComboBox destBox;
    private JLabel destLabel;
    private JButton okButton;
    private JButton deleteButton;
    
    private JPanel boxPanel;
    private JPanel buttonPanel;
    
    private JPanel flightInfoPanel;
    
    public View()
    {
        super(new BorderLayout());
        super.setPreferredSize(new Dimension(300, 300));
        
        
        boxPanel = new JPanel(new BorderLayout()); 
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        
        originPanel = new JPanel(new BorderLayout());
        originLabel = new JLabel("Origin:");
        originPanel.add(originLabel, BorderLayout.WEST);
        originBox = new JComboBox();
        originBox.setPreferredSize(new Dimension(230, 25));
        //originPanel.setBorder(blackLine);
        originPanel.add(originBox, BorderLayout.EAST);
        
        destPanel = new JPanel(new BorderLayout());
        destLabel = new JLabel("Destination:");
        destPanel.add(destLabel, BorderLayout.WEST);
        destBox = new JComboBox();
        destBox.setPreferredSize(new Dimension(230, 25));
        destPanel.add(destBox, BorderLayout.EAST);
        //destPanel.setBorder(blackLine);
        boxPanel.add(originPanel, BorderLayout.NORTH);
        boxPanel.add(destPanel, BorderLayout.SOUTH);
        
        //originLabel -> originBox
        //destLabel -> destBox
        super.add(boxPanel, BorderLayout.NORTH);
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(super.getWidth(), 40));
        okButton = new JButton("OK");
        deleteButton = new JButton("Delete");
        buttonPanel.add(okButton);
        buttonPanel.add(deleteButton);
        buttonPanel.setBorder(blackLine);
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(300, 300));
        centerPanel.setBackground(new Color(70,89,75));
        centerPanel.setBorder(blackLine);
        super.add(centerPanel, BorderLayout.CENTER);
        super.add(buttonPanel, BorderLayout.SOUTH);
        
        
    }
    
    
    
    
    
    
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new View());
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
}
