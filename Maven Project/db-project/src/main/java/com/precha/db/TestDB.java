package com.precha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) { 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost/blueshop?characterEncoding=utf-8";
			Connection con = DriverManager.getConnection(dbURL, "prechakr","7777");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("สวัสดี");
	}

}
