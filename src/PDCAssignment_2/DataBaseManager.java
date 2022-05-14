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
import java.util.logging.Level;
import java.util.logging.Logger;


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

    public DataBaseManager() {
        establishConnection();
        
        try {
            createTestTable();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        DataBaseManager dbManager = new DataBaseManager();
        
        //System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void createTestTable() throws SQLException
    {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            System.out.println("Checking if table exists.");
            String tableName = "Test";
            if(!tableExists(tableName))
            {
                System.out.println("Creating table");
                statement.executeUpdate("CREATE TABLE "+ tableName +" (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            else
            {
                System.out.println("Table exists.");
            }
            //statement = conn.createStatement();
            System.out.println("Attempting to insert values.");
            statement.addBatch("INSERT INTO Test VALUES('hello', 'hello', 10)");
            statement.executeBatch();
            statement.close();
            closeConnections();
    }
    

    
    //Establish connection
    public void establishConnection() {
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

    

