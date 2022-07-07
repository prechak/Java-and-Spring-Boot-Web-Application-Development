package com.precha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
	
	private Connection con;
	
	public TeacherDAO() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dbURL = "jdbc:mysql://localhost/registration?characterEncoding=utf-8";
		
		con = DriverManager.getConnection(dbURL, "root", "P@ssw0rd");
	}
	
	public Teacher findOne(String id) throws SQLException {
		PreparedStatement pStatement = con.prepareStatement("SELECT * FROM teacher WHERE tid = ?"); 
		pStatement.setString(1, id);
		ResultSet resultSet = pStatement.executeQuery();
		
		Teacher t = null;
		if( resultSet.next()) {
			t = new Teacher(resultSet.getString("tid"), resultSet.getString("tname"), resultSet.getString("status"));
		}
		return t;
	}

	public static void main(String[] args) {
		try {
			TeacherDAO dao = new TeacherDAO();
			Teacher t = dao.findOne("2");
			System.out.println(t.getTeacherName() + " " + t.getStatus());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
