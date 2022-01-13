package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public ConnectionUtil() {
}
   
    //Creating the connection and testing that we can connect
    public static Connection getConnection() throws SQLException, IOException {
    	Connection conn;
    	FileInputStream propinput = new FileInputStream( "C:\\Users\\blanc\\OneDrive\\Documents\\JDBC-Setup.txt");
    	Properties props = new Properties();
    	props.load(propinput);
    	String url = (String) props.get("url");
    	String username = (String) props.get("username");
    	String password = (String) props.get("password");
    	
    	return DriverManager.getConnection(url, username, password);
    	
    }
    
    public static void main(String [] args) {
    	try(Connection connection = getConnection()){
    		
    		System.out.println("Connection successful");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
}
