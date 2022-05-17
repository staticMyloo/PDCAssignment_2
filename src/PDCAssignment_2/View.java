/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

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

    private JButton loginButton;
    private JPanel loginPanel;
    private JLabel userNameLabel, passWordLabel, passPortLabel;
    public JFormattedTextField userField, passWordField, passPortField;
    private JButton showFlightButton;
    public ButtonGroup bg;
    private final String planeIcon = "<html>\u2708<html>";
    
    
    public View() throws ParseException {
        setTitle("Booking System");
        setPreferredSize(new Dimension(300, 300));

        boxPanel = new JPanel(new BorderLayout());
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        
        loginPanel = new JPanel(new GridLayout(5,2,0,15));
        
        JLabel gapfill1 = new JLabel(planeIcon, SwingConstants.CENTER);
        JLabel gapfill2 = new JLabel(planeIcon, SwingConstants.CENTER);
        try {
            MaskFormatter mask = new MaskFormatter("************");
            userNameLabel = new JLabel("Username:");
            userField = new JFormattedTextField(mask);
            userField.setPreferredSize(new Dimension(200, 30));
            passWordLabel = new JLabel("Password:");
            passWordField = new JFormattedTextField(mask);
            passPortLabel = new JLabel("Passport no:");
            passPortField = new JFormattedTextField(mask);
        } catch (ParseException ex) {}
        
        
        
        JLabel gapfill3 = new JLabel(planeIcon, SwingConstants.CENTER);
        JLabel gapfill4 = new JLabel(planeIcon, SwingConstants.CENTER);
        
        loginPanel.add(gapfill1);
        loginPanel.add(gapfill2);
        loginPanel.add(userNameLabel);
        loginPanel.add(userField);
        loginPanel.add(passWordLabel);
        loginPanel.add(passWordField);
        loginPanel.add(passPortLabel);
        loginPanel.add(passPortField);
        loginPanel.add(gapfill3);
        loginPanel.add(gapfill4);
        loginPanel.setBorder(blackLine);
        
        
        
        
        
        originPanel = new JPanel(new BorderLayout());
        originLabel = new JLabel("Origin:");
        originPanel.add(originLabel, BorderLayout.WEST);
        String[] orgString = {"AKL","WEL","CHCH"};
        originBox = new JComboBox(orgString);
        originBox.setPreferredSize(new Dimension(200, 25));
        //originPanel.setBorder(blackLine);
        originPanel.add(originBox, BorderLayout.EAST);

        destPanel = new JPanel(new BorderLayout());
        destLabel = new JLabel("Destination:");
        destPanel.add(destLabel, BorderLayout.WEST); 
        String[] destString = {"CHCH","WEL","AKL"};
        destBox = new JComboBox(destString);
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
        showFlightButton = new JButton("Show Flights");
        //buttonPanel.add(okButton);
        //buttonPanel.add(deleteButton);
        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        buttonPanel.setBorder(blackLine);
        flightSelectorPanel = new JPanel(new BorderLayout());
        flightSelectorPanel.setPreferredSize(new Dimension(300, 300));
        flightSelectorPanel.setBackground(new Color(70, 89, 75));
        flightSelectorPanel.setBorder(blackLine);
        
        String test[] = {};
        flightList = new JList(test);
        flightSelectorPanel.add(boxPanel, BorderLayout.NORTH);
        flightList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scroll = new JScrollPane(flightList);
        scroll.setPreferredSize(new Dimension(300,135));
        //super.add(boxPanel, BorderLayout.NORTH);
        //flightList.setPreferredSize(new Dimension(300, 135));
        flightSelectorPanel.add(scroll, BorderLayout.SOUTH);
        
        timePanel = new JPanel();
        timeLabel = new JLabel("Time:");
        timeButton1 = new JRadioButton("10:00");timeButton1.setActionCommand("10:00");
        timeButton2 = new JRadioButton("12:30");timeButton2.setActionCommand("12:30");
        timeButton3 = new JRadioButton("16:00");timeButton3.setActionCommand("16:00");
        timeButton4 = new JRadioButton("19:00");timeButton4.setActionCommand("19:00");
        bg = new ButtonGroup();
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
        timeButton1.setSelected(true);
        
        
        flightSelectorPanel.add(timePanel, BorderLayout.CENTER);
        
        add(loginPanel, BorderLayout.CENTER);
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
    
    public JPanel getButtonPanel()
    {
        return buttonPanel;
    }
    
    
    public void addFlightSelectorPanel()
    {
        this.getButtonPanel().remove(loginButton);
        this.getContentPane().remove(loginPanel);
        revalidate();
        this.getButtonPanel().add(okButton);
        this.getButtonPanel().add(showFlightButton);
        this.getButtonPanel().add(deleteButton);
        revalidate();
        super.getContentPane().add(flightSelectorPanel, BorderLayout.CENTER);
        flightSelectorPanel.setVisible(true);
        revalidate();
    }
    
    public void updateFlightList(ArrayList list)
    {
        flightList.setListData(list.toArray());
        System.out.println(Arrays.toString(list.toArray()));
        this.revalidate();
        this.repaint();
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
        Data data = (Data) o1;
        if(!data.loginFlag)
        {
            System.out.println("login rejected");
            this.passWordField.setText("INVALID PASSWORD");
            this.revalidate();
            this.repaint();
        }
//        else if(data.loginFlag)
//        {
//            this.addFlightSelectorPanel();
//            this.revalidate();
//            this.repaint();
//        }
    }

    void addActionListener(ActionListener listener) 
    {
        this.okButton.addActionListener(listener);
        this.deleteButton.addActionListener(listener);
        this.loginButton.addActionListener(listener);
        this.showFlightButton.addActionListener(listener);
    }

    /**
     * @return the originBox
     */
    public JComboBox getOriginBox() {
        return originBox;
    }

    /**
     * @return the destBox
     */
    public JComboBox getDestBox() {
        return destBox;
    }

}
