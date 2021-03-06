/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDCAssignment_2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author myles
 */
public final class DataBaseManager 
{
    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "123"; //your DB password
    private static final String URL = "jdbc:derby:BookingDataBase; create=true";  //url of the DB host

    Connection conn;
    //Statement statement;
    TripList trips;
    Trip selectedTrip;
    
    public DataBaseManager() {
        
        try {
            establishConnection();
            createCustomerTable();
            createTripList();
            createPaymentHistoryTable();
            createPaymentReceiptTable();
        } catch (SQLException ex) {}
    }
//
//    public static void main(String[] args) throws SQLException {
//        DataBaseManager dbManager = new DataBaseManager();
//        //System.out.println(dbManager.getConnection());
//    }

    public Connection getConnection() {
        return this.conn;
    }

    public Receipt generateReceipt(String name, String passport, String payment, String seat) throws SQLException
    {
        Statement statement = conn.createStatement();
        /*
        SELECT USERID, PASSPORT, PAYMENT, SEAT
        FROM RECEIPTS
        WHERE userid LIKE 'myles'
        AND passport LIKE 'passport'
        AND payment LIKE 'VISA'
        AND seat LIKE '1Z'
        */
        
               String query = "SELECT RECEIPT_ID, USERID, PASSPORT, PAYMENT, SEAT ";
               query+= "FROM RECEIPTS ";
               query+= "WHERE USERID = '"+name+"' ";
               query+= "AND PASSPORT = '"+passport+"' ";
               query+= "AND PAYMENT = '"+payment+"' ";
               query+= "AND SEAT = '"+seat+"'";
               ResultSet rs = statement.executeQuery(query);
               
               if(rs.next())
               {
                   //System.out.println("rs successful");
                   int receiptNo = rs.getInt(1);
                   String receiptName = rs.getString("USERID");
                   String receiptPass = rs.getString("PASSPORT");
                   String receiptPayment = rs.getString("PAYMENT");
                   String receiptSeat = rs.getString("SEAT");
                   //System.out.println(receiptNo+" "+receiptName+" "+receiptPass+" "+receiptPayment+" "+receiptSeat);
                   return new Receipt(receiptName, receiptPass, receiptPayment, selectedTrip, receiptSeat, receiptNo);    
               }
               else
               {
                   //System.out.println("receipt failed");
                   return null;
               }
    }
    
    public CardData setCard(String card, String ccv)
    {
        CardData data = new CardData();
        data.cardNum = card;
        data.ccv = ccv;
        return data;
    }
    
    public Data checkUser(String userName, String passWord, String passPortNo)
    {   
        
            Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password FROM CUSTOMERS WHERE userid = '"+userName+"'");
            
            if(rs.next())
            {
                //System.out.println("result set successful");
                String pass = rs.getString("password");
                if(passWord.trim().compareTo(pass.trim()) == 0)
                {
                    //System.out.println("login accepted");
                    data.userName = userName;
                    data.passWord = passWord;
                    data.passPortNo = passPortNo;
                    data.loginFlag = true;
                }
                else
                {
                    //System.out.println("login rejected");
                    data.loginFlag = false;
                }
            }
            else
            {
                //System.out.println("no such user");
                statement.executeUpdate("INSERT INTO CUSTOMERS VALUES('"+userName.trim()+"', '"+passWord.trim()+"', '"+passPortNo.trim()+"')");
                data.userName = userName;
                data.passWord = passWord;
                data.passPortNo = passPortNo;
                data.loginFlag = true;
            }
            
        } catch (SQLException ex) {}
            return data;
    }
    
    public ArrayList<Trip> getSelectedFlights(String origin, String dest, String time)
    {
        ArrayList<Trip> set = new ArrayList<>();
        trips = new TripList();
        try
        {
            //System.out.println(origin+" "+dest+" "+time);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT origin, destination, time FROM TRIPS "
                    + "WHERE origin = '"+origin+"' "
                            + "AND destination = '"+dest+"' "
                                    + "AND time = '"+time+"'");
            while (rs.next()) 
            {
                //System.out.println("rs successful");
                String tempOrg = rs.getString("origin");
                String tempDest = rs.getString("destination");
                String tempTime = rs.getString("time");

                for (int i = 0; i < trips.getTripList().size(); i++) 
                {
                    Trip temp = (Trip) trips.getTripList().get(i);
                    if (temp.validateTrip(tempOrg, tempDest, tempTime)) 
                    {
                        set.add(temp);
                        trips.getTripList().remove(temp);
                    }
                }
            }
             rs.close();
        }
        catch(SQLException e)
        {}
        
        return set;
        
    }
    
    
    
    public Data insertPaymentInfo(String user, String passport, String origin, String destination, String payment) throws SQLException
    {
        Data data = new Data();
        //System.out.println("attempting to insert data");
        Statement statement = conn.createStatement();
        String insertPayment = "INSERT INTO PAYMENT VALUES ('"+user+"', '"+passport+"', '"+origin+"', '"+destination+"', '"+
                payment+"')";
        statement.executeUpdate(insertPayment);
        statement.close();
        data.paySelect = true;
        return data;
        
    }
    
    public void createPaymentReceiptTable() throws SQLException
    {
        try 
            (Statement statement = conn.createStatement()) 
        {
            String tableName = "RECEIPTS";
            
            if(!tableExists(tableName))
            {
                statement.executeUpdate("CREATE TABLE "+ tableName+" (receipt_id INTEGER PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                        + "userid VARCHAR(12), passport VARCHAR(12)"
                        +", payment VARCHAR(12), seat VARCHAR(2))");
                //System.out.println(tableName+" created");
            }
        }
    }
    
    public void insertPaymentReceiptInfo(String user, String passport, String payment, String seat) throws SQLException
    {
        
        //System.out.println("Inserting payment receipt record");
        Statement statement = conn.createStatement();
        String insertReceipt = "INSERT INTO RECEIPTS (userid, passport, payment, seat) VALUES ('"+user.trim()+"', '"+passport.trim()+"', '"+payment+"', '"+seat+"')";
        //System.out.println("INSERT INTO RECEIPTS (userid, passport, payment, seat) VALUES ('"+user+"', '"+passport+"', '"+payment+"', '"+seat+"')");
        statement.executeUpdate(insertReceipt);
    }
    
    public void createPaymentHistoryTable() throws SQLException
    {
        //System.out.println("attempting to create pay table");
        Statement statement = conn.createStatement();
        String tableName = "PAYMENT";
        
        if(!tableExists(tableName))
        {
            statement.executeUpdate("CREATE TABLE "+ tableName +" (userid VARCHAR(12), passport VARCHAR(12)"
                    +", origin VARCHAR(12), destination VARCHAR(12), payment VARCHAR(12))");
        }
        
        statement.close();
    }
    
    
    public void createTripList() throws SQLException
    {
        Statement statement = conn.createStatement();
        String tableName = "TRIPS";
        
        if(!tableExists(tableName))
        {
            trips = new TripList();
            statement.executeUpdate("CREATE TABLE "+ tableName +" (origin VARCHAR(12), destination VARCHAR(12), triplength VARCHAR(12), "
                    + "time VARCHAR(12), date VARCHAR(12), cost INT)");
            
            for(int i = 0; i < trips.getTripList().size(); i++)
            {
               Trip temp = (Trip) trips.getTripList().get(i);
               String tempOrigin = temp.getOrigin();
               String tempDest = temp.getDestination();
               String tempLength = temp.getTripLength();
               String tempTime = temp.getTime();
               String tempDate = temp.getTripDate();
               int tempCost = temp.getCost();
               
               String insertTrip = "INSERT INTO TRIPS VALUES ('"+tempOrigin+"', '"+tempDest+"', '"+tempLength+"', '"+tempTime+"', '"+tempDate+"',"
                       + " "+tempCost+")";
               
                //System.out.println(insertTrip);
               
                statement.addBatch(insertTrip);
                
            }
            statement.executeBatch();
        }
        statement.close();
    }
    
    public void createCustomerTable() throws SQLException
    {
            
            Statement statement = conn.createStatement();
            //System.out.println("Checking if table exists.");
            String tableName = "CUSTOMERS";
            if(!tableExists(tableName))
            {
                //System.out.println("Creating table");
                //CREATE TABLE "+ tableName +" (origin VARCHAR(12), destination VARCHAR(12), triplength VARCHAR(12), "+ "time VARCHAR(12), date VARCHAR(12), cost INT)");
                statement.executeUpdate("CREATE TABLE CUSTOMERS (userid VARCHAR(12), password VARCHAR(12), passport VARCHAR(12))");
                
            }
            statement.close();
    }
    

    
    //Establish connection
    public void establishConnection() throws SQLException {
        conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections()
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //Must compare if table DOESN'T exist in program
    public boolean tableExists(String table) throws SQLException
    {
        boolean flag = false;
        try 
        {
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, null, null);

            while (rs.next()) 
            {
                String getTable = rs.getString("TABLE_NAME");
                if (table.compareToIgnoreCase(getTable) == 0) 
                {
                    flag = true;
                }
            }
           
            rs.close();
            
        } 
        catch (SQLException ex) {}
        
        return flag;
    }
}

    

