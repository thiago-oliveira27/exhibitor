package com.poo.exhibitor.connection.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DataBaseFacade implements DataBaseInterface {

	
private Connection connection;
    
	@Override
    public void connect(){
    	Dotenv dotenv = Dotenv.load();        
    	String dbHost = dotenv.get("DB_HOST");
    	String dbUsername = dotenv.get("DB_USERNAME");
    	String dbPassword = dotenv.get("DB_PASSWORD");
    	try {
    		connection = DriverManager.getConnection(dbHost, dbUsername, dbPassword);
            System.out.println("Connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
	@Override
    public void disconnect() {
        
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error when trying to close the connection: " + e.getMessage());
        }
    }
    
	@Override
    public ResultSet executeQuery(String query, Long id) {
        
        ResultSet resultSet = null;
        
        try {
        	PreparedStatement stt = connection.prepareStatement(query);
            stt.setLong(1, id);            
            resultSet = stt.executeQuery();
            
        } catch (SQLException e) {
            System.err.println("Error executing the query: " + e.getMessage());
        }
        
        return resultSet;
    }
    
}
