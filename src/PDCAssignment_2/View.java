/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author myles
 */
public class View extends JFrame implements Observer{
    

    private JPanel originPanel;
    private JComboBox originBox;
    private JLabel originLabel;
    private JPanel destPanel;
    private JComboBox destBox;
    private JLabel destLabel;
    public JButton okButton;
    private JButton deleteButton;

    private JPanel boxPanel;
    private JPanel buttonPanel;
    private JPanel timePanel;
    private JLabel timeLabel;
    private JRadioButton timeButton1, timeButton2, timeButton3, timeButton4;
    private JPanel flightSelectorPanel;
    private JList flightList;

    
    
    public View() {
        
        setPreferredSize(new Dimension(300, 300));

        boxPanel = new JPanel(new BorderLayout());
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        
        
        
        
        
        
        
        
        originPanel = new JPanel(new BorderLayout());
        originLabel = new JLabel("Origin:");
        originPanel.add(originLabel, BorderLayout.WEST);
        originBox = new JComboBox();
        originBox.setPreferredSize(new Dimension(200, 25));
        //originPanel.setBorder(blackLine);
        originPanel.add(originBox, BorderLayout.EAST);

        destPanel = new JPanel(new BorderLayout());
        destLabel = new JLabel("Destination:");
        destPanel.add(destLabel, BorderLayout.WEST);
        destBox = new JComboBox();
        destBox.setPreferredSize(new Dimension(200, 25));
        destPanel.add(destBox, BorderLayout.EAST);
        //destPanel.setBorder(blackLine);
        boxPanel.add(originPanel, BorderLayout.NORTH);
        boxPanel.add(destPanel, BorderLayout.SOUTH);
        boxPanel.setPreferredSize(new Dimension(200,50));
        //originLabel -> originBox
        //destLabel -> destBox
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(super.getWidth(), 40));
        okButton = new JButton("OK");
        deleteButton = new JButton("Delete");
        buttonPanel.add(okButton);
        buttonPanel.add(deleteButton);
        buttonPanel.setBorder(blackLine);
        flightSelectorPanel = new JPanel(new BorderLayout());
        flightSelectorPanel.setPreferredSize(new Dimension(300, 300));
        flightSelectorPanel.setBackground(new Color(70, 89, 75));
        flightSelectorPanel.setBorder(blackLine);
        
        String test[] = {"one", "two", "three", "four"};
        flightList = new JList(test);
        flightSelectorPanel.add(boxPanel, BorderLayout.NORTH);
        //super.add(boxPanel, BorderLayout.NORTH);
        flightList.setPreferredSize(new Dimension(300, 135));
        flightSelectorPanel.add(flightList, BorderLayout.SOUTH);
        
        timePanel = new JPanel();
        timeLabel = new JLabel("Time:");
        timeButton1 = new JRadioButton("10:00");
        timeButton2 = new JRadioButton("12:30");
        timeButton3 = new JRadioButton("16:00");
        timeButton4 = new JRadioButton("19:00");
        ButtonGroup bg = new ButtonGroup();
        bg.add(timeButton1);
        bg.add(timeButton2);
        bg.add(timeButton3);
        bg.add(timeButton4);
        timePanel.add(timeLabel);
        timePanel.add(timeButton1);
        timePanel.add(timeButton2);
        timePanel.add(timeButton3);
        timePanel.add(timeButton4);
        timePanel.setPreferredSize(new Dimension(300, 50));
        
        flightSelectorPanel.add(timePanel, BorderLayout.CENTER);
        
        
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        //create add login frame
        //create flight selector frame
        //create planelayout frame maybe? use Jbuttons for seats.
        //create pay info screen
        //create pay complete screen
        //show final ticket
        

    }

    public void addFlightSelectorPanel()
    {
        super.getContentPane().add(flightSelectorPanel, BorderLayout.CENTER);
        flightSelectorPanel.setVisible(true);
        revalidate();
    }
    
    public JPanel getFlightPanel()
    {
        return flightSelectorPanel;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Booking System");
        

    }
    
    public JButton getOkButton()
    {
        return okButton;
    }
    
    public JButton getDeleteButton()
    {
        return deleteButton;
    }

    @Override
    public void update(Observable o, Object o1) 
    {
        
    }

    void addActionListener(ActionListener listener) 
    {
        this.okButton.addActionListener(listener);
        this.deleteButton.addActionListener(listener);
    }

}
