/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

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
    private JPanel boxPanel;
    private JPanel buttonPanel;
    private JPanel timePanel;
    private JLabel timeLabel;
    private JRadioButton timeButton1, timeButton2, timeButton3, timeButton4;
    private JPanel flightSelectorPanel;
    public JList flightList;
    private JButton loginButton;
    private JPanel loginPanel;
    private JLabel userNameLabel, passWordLabel, passPortLabel;
    public JFormattedTextField userField, passPortField;
    public JPasswordField passWordField;
    public JButton showFlightButton, goBackButton, confirmFlightButton, payButton;
    public ButtonGroup bg, seatGroup, payGroup;
    private final String planeIcon = "<html>\u2708<html>";
    private JPanel userFlightPanel, seatSelectorPanel, userSeatPanel, trueSeatPanel;
    public JLabel userInfoLabel, flightInfoLabel, seatNumberLabel;
    public JPanel cardPanel;
    public JToggleButton mCardButton, visaButton;
    private ImageIcon mCardIcon, visaIcon;
    public JPanel payPanel;
    public JTextField cardNumberField, ccvField;
    public JLabel cardNumberLabel, cardccvLabel;
    public JPanel paySuccess;
    public JButton exitButton;
    public JTextArea receiptPane;
    
    
    public View() throws ParseException {
        setTitle("Booking System");
        setPreferredSize(new Dimension(300, 300));
        UIManager.put("ToggleButton.select", Color.BLUE);
        boxPanel = new JPanel(new BorderLayout());
        //Border blackLine = BorderFactory.createLineBorder(Color.black);
        
        loginPanel = new JPanel(new GridLayout(5,2,0,15));
        
        JLabel gapfill1 = new JLabel(planeIcon, SwingConstants.CENTER);
        JLabel gapfill2 = new JLabel(planeIcon, SwingConstants.CENTER);
        try {
            MaskFormatter mask = new MaskFormatter("************");
            userNameLabel = new JLabel("Username:");
            userField = new JFormattedTextField(mask);
            userField.setPreferredSize(new Dimension(200, 30));
            passWordLabel = new JLabel("Password:");
            passWordField = new JPasswordField(12);
            
            //sets password field to a limit as to not cause database errors
            PlainDocument document = (PlainDocument) passWordField.getDocument();
            document.setDocumentFilter(new DocumentFilter()
            {
                @Override
                public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                {
                    String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                    if (string.length() <= 12) 
                    {
                        super.replace(fb, offset, length, text, attrs);
                    }
             
                }
            });
            
            
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
        //loginPanel.setBorder(blackLine);
        
        originPanel = new JPanel(new BorderLayout());
        originLabel = new JLabel("Origin:");
        originPanel.add(originLabel, BorderLayout.WEST);
        String[] orgString = {"AKL","WEL","CHCH"};
        originBox = new JComboBox(orgString);
        originBox.setPreferredSize(new Dimension(200, 25));
        originPanel.add(originBox, BorderLayout.EAST);

        destPanel = new JPanel(new BorderLayout());
        destLabel = new JLabel("Destination:");
        destPanel.add(destLabel, BorderLayout.WEST); 
        String[] destString = {"CHCH","WEL","AKL"};
        destBox = new JComboBox(destString);
        destBox.setPreferredSize(new Dimension(200, 25));
        destPanel.add(destBox, BorderLayout.EAST);
        boxPanel.add(originPanel, BorderLayout.NORTH);
        boxPanel.add(destPanel, BorderLayout.SOUTH);
        boxPanel.setPreferredSize(new Dimension(200,50));
       
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(super.getWidth(), 40));
        okButton = new JButton("OK");
        showFlightButton = new JButton("Show Flights");
        goBackButton = new JButton("Go back");
        confirmFlightButton = new JButton("Confirm");
        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        flightSelectorPanel = new JPanel(new BorderLayout());
        flightSelectorPanel.setPreferredSize(new Dimension(300, 300));
        flightSelectorPanel.setBackground(new Color(70, 89, 75));
        
        String test[] = {};
        flightList = new JList(test);
        flightSelectorPanel.add(boxPanel, BorderLayout.NORTH);
        flightList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scroll = new JScrollPane(flightList);
        scroll.setPreferredSize(new Dimension(300,135));
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
        

        seatSelectorPanel = new JPanel(new BorderLayout());
        userSeatPanel = new JPanel(new BorderLayout());
        JPanel leftFill = new JPanel();
        JPanel rightFill = new JPanel();
        leftFill.setPreferredSize(new Dimension(40, 183));
        rightFill.setPreferredSize(new Dimension(40, 183));
        userSeatPanel.add(leftFill, BorderLayout.WEST);
        userSeatPanel.add(rightFill, BorderLayout.EAST);
        trueSeatPanel = new JPanel();
        userSeatPanel.add(trueSeatPanel, BorderLayout.CENTER);
        userFlightPanel = new JPanel(new BorderLayout());
        userInfoLabel = new JLabel();
        flightInfoLabel = new JLabel();
        seatNumberLabel = new JLabel("Seat:            ");
        userFlightPanel.add(userInfoLabel, BorderLayout.WEST);
        userFlightPanel.add(seatNumberLabel, BorderLayout.EAST);
        userFlightPanel.add(flightInfoLabel, BorderLayout.SOUTH);
        userFlightPanel.setPreferredSize(new Dimension(300, 40));
        userSeatPanel.setPreferredSize(new Dimension(300, 181));
        seatSelectorPanel.add(userFlightPanel, BorderLayout.NORTH);
        seatSelectorPanel.add(userSeatPanel, BorderLayout.SOUTH);
        
        cardPanel = new JPanel(new GridLayout(4,1));
        JPanel topFill = new JPanel();
        JPanel bottomFill = new JPanel();
        mCardIcon = new ImageIcon("./resources/mastercard.png");
        Image img1 = mCardIcon.getImage();
        Image newImg1 = img1.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
        mCardIcon = new ImageIcon(newImg1);
        mCardButton = new JToggleButton("MasterCard", mCardIcon);
        mCardButton.setHorizontalAlignment(SwingConstants.LEFT);
        
        visaIcon = new ImageIcon("./resources/visa.png");
        Image img2 = visaIcon.getImage();
        Image newImg2 = img2.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
        visaIcon = new ImageIcon(newImg2);
        
        visaButton = new JToggleButton("Visa", visaIcon);
        visaButton.setHorizontalAlignment(SwingConstants.LEFT);
        visaButton.setActionCommand("Visa");
        mCardButton.setActionCommand("Mastercard");
        cardPanel.add(topFill);
        cardPanel.add(mCardButton);
        cardPanel.add(visaButton);
        cardPanel.add(bottomFill);
        payGroup = new ButtonGroup();
        payGroup.add(visaButton);
        payGroup.add(mCardButton);
        
        
        payPanel = new JPanel(new GridLayout(4,2,0,15));
        JLabel topFill1 = new JLabel();
        JLabel topFill2 = new JLabel();
        cardNumberLabel = new JLabel("Card No: 6 DIGITS");
        cardNumberField = new JTextField();
        cardNumberField.setPreferredSize(new Dimension(200,50));
        cardccvLabel = new JLabel("CCV: 3 DIGITS");
        ccvField = new JTextField();
        ccvField.setPreferredSize(new Dimension(200,50));
        JLabel bottomFill1 = new JLabel();
        JLabel bottomFill2 = new JLabel();
        payPanel.add(topFill1);
        payPanel.add(topFill2);
        payPanel.add(cardNumberLabel);
        payPanel.add(cardNumberField);
        payPanel.add(cardccvLabel);
        payPanel.add(ccvField);
        payPanel.add(bottomFill1);
        payPanel.add(bottomFill2);
        payButton = new JButton("Pay now");
        
        paySuccess = new JPanel();
        exitButton = new JButton("Click to exit.");
        receiptPane = new JTextArea();
        receiptPane.setEditable(false);
        receiptPane.setFont(new Font("Courier", Font.BOLD, 14));
        
        add(loginPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    public JPanel getSeatSelectorPanel()
    {
        return seatSelectorPanel;
    }
    
    public JPanel getButtonPanel()
    {
        return buttonPanel;
    }
    
   
    public void addPaySuccessPanel()
    {
        super.getContentPane().remove(payPanel);
        getButtonPanel().remove(payButton);
        getButtonPanel().add(exitButton);
        super.getContentPane().add(receiptPane, BorderLayout.CENTER);
        
        repaint();
        revalidate();
    }
    
    public void addPayPanel()
    {
        super.getContentPane().removeAll();
        buttonPanel.remove(okButton);
        buttonPanel.remove(goBackButton);
        buttonPanel.remove(confirmFlightButton);
        buttonPanel.add(payButton);
        super.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        super.getContentPane().add(payPanel, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
    }
    
    public void setSeats(Trip trip)
    {
        trueSeatPanel.setLayout(new GridLayout(trip.getPlane().getRows(), trip.getPlane().getRows()));
        int rows = trip.getPlane().getRows();
        int cols = trip.getPlane().getColumns();
        seatGroup = new ButtonGroup();
        int seatRow = 1;
        char col = 'A';
        SeatComponent[][] seats = trip.getPlane().getSeatComps();
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                seats[i][j] = new SeatComponent(new BorderLayout());
                seats[i][j].setActionCommand(""+seatRow+col);
                seatGroup.add(seats[i][j]);
                trueSeatPanel.add(seats[i][j]);
                this.repaint();
                this.revalidate();
                col +=1;
            }
            col = 'A';
            seatRow++;
        }
    }
    
    
    public void addFlightSelectorPanel()
    {
        this.getButtonPanel().remove(loginButton);
        this.getContentPane().remove(loginPanel);
        revalidate();
        this.getButtonPanel().add(okButton);
        this.getButtonPanel().add(showFlightButton);
        revalidate();
        super.getContentPane().add(flightSelectorPanel, BorderLayout.CENTER);
        flightSelectorPanel.setVisible(true);
        revalidate();
    }
  
    
    public void reAddFlightSelectorPanel()
    {
        this.trueSeatPanel.removeAll();
        this.seatGroup = null;
        this.getContentPane().remove(seatSelectorPanel);
        this.getButtonPanel().remove(goBackButton);
        this.getButtonPanel().remove(confirmFlightButton);
        repaint();
        revalidate();
        this.getButtonPanel().add(okButton);
        this.getButtonPanel().add(showFlightButton);
        revalidate();
        super.getContentPane().add(flightSelectorPanel, BorderLayout.CENTER);
        flightSelectorPanel.setVisible(true);
        revalidate();
    }
    
    public void addSeatSelectorPanel()
    {
        trueSeatPanel.setVisible(true);
        this.getContentPane().remove(flightSelectorPanel);
        this.getButtonPanel().remove(showFlightButton);
        this.getButtonPanel().remove(okButton);
        super.getContentPane().add(seatSelectorPanel, BorderLayout.CENTER);
        seatSelectorPanel.setVisible(true);
        this.getButtonPanel().add(confirmFlightButton);
        this.getButtonPanel().add(goBackButton);
        this.revalidate();
        this.repaint();
    }
   
    public void addCardPanel()
    {
        trueSeatPanel.removeAll();
        this.getContentPane().remove(trueSeatPanel);
        trueSeatPanel.setVisible(false);
        this.repaint();
        this.revalidate();
        userSeatPanel.add(cardPanel, BorderLayout.CENTER);
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
        cardPanel.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
    public void updateFlightList(ArrayList list)
    {
        flightList.setListData(list.toArray());
        //System.out.println(Arrays.toString(list.toArray()));
        this.revalidate();
        this.repaint();
    }
    
    public JPanel getFlightPanel()
    {
        return flightSelectorPanel;
    }
    
    public JButton getOkButton()
    {
        return okButton;
    }

    @Override
    public void update(Observable o, Object o1) 
    {
        Data data = (Data) o1;
        if(!data.loginFlag)
        {
            //System.out.println("login rejected");
            this.passWordField.setText("INVALID PASSWORD");
            this.revalidate();
            this.repaint();
        }
    }

    public void addSeatItemListener(ItemListener listener, Trip trip)
    {   
        int rows = trip.getPlane().getRows();
        int cols = trip.getPlane().getColumns();
        
        for(int i = 0; i < rows;i++)
        {
            for(int j = 0; j < cols; j++)
            {
                trip.getPlane().getSeatComps()[i][j].addItemListener(listener);
            }
        }
    }
    
    void addSeatActionListener(ActionListener listener, Trip trip)
    {
        int rows = trip.getPlane().getRows();
        int cols = trip.getPlane().getColumns();
        
        for(int i = 0; i < rows;i++)
        {
            for(int j = 0; j < cols; j++)
            {
                trip.getPlane().getSeatComps()[i][j].addActionListener(listener);
            }
        }
    }
    
    void addActionListener(ActionListener listener) 
    {
        this.okButton.addActionListener(listener);
        this.loginButton.addActionListener(listener);
        this.showFlightButton.addActionListener(listener);
        this.goBackButton.addActionListener(listener);
        this.confirmFlightButton.addActionListener(listener);
        this.payButton.addActionListener(listener);
        this.exitButton.addActionListener(listener);
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

    /**
     * @return the userFlightPanel
     */
    public JPanel getUserFlightPanel() {
        return userFlightPanel;
    }

    /**
     * @return the userInfoLabel
     */
    public JLabel getUserInfoLabel() {
        return userInfoLabel;
    }

    /**
     * @return the flightInfoLabel
     */
    public JLabel getFlightInfoLabel() {
        return flightInfoLabel;
    }

    /**
     * @return the userSeatPanel
     */
    public JPanel getUserSeatPanel() {
        return userSeatPanel;
    }

}
