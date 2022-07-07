package com.precha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDB {

	public static void main(String[] args) {
		try {
	        // 1. get JDBC Driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        // 2. Assign URL for connecting database
	        String dbURL = "jdbc:mysql://localhost/registration?characterEncoding=utf-8";
	        
	        // 3. Database connection
	        Connection con = DriverManager.getConnection(dbURL, "root", "P@ssw0rd");
	        
	        // 4. Prepare SQL command for processing
	        PreparedStatement pStatement = con.prepareStatement("SELECT * FROM teacher"); 

	        // 5. Assign SQL command to database
	        ResultSet resultSet = pStatement.executeQuery();

	        // 6. Get result at database and return 
	        while (resultSet.next()) {
	            int tid = resultSet.getInt("tid");  
	            String tname = resultSet.getString("tname");
	            String status = resultSet.getString("status");
	            if(status.equals("s")) status = "single";
	            else if(status.equals("m")) status = "married";
	            System.out.println(tid + "," + tname + "," + status);
	        }
		// 7. Close connection
	        con.close();

	    } catch (ClassNotFoundException e) {
	        System.err.println("Error loading driver: " + e);
	    } catch (SQLException e) {
	        System.err.println("Error database connection: " + e);
	    }
	}

}
