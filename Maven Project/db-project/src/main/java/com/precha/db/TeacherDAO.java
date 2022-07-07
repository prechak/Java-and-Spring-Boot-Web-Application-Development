package com.precha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAO {
	
	private Connection con;
	
	public TeacherDAO() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dbURL = "jdbc:mysql://localhost/registration?characterEncoding=utf-8";
		
		con = DriverManager.getConnection(dbURL, "root", "P@ssw0rd");
	}
	
	public Teacher mapping(ResultSet resultSet) throws SQLException {
		return new Teacher(resultSet.getString("tid"), resultSet.getString("tname"), resultSet.getString("status"));
	}
	
	public Teacher findOne(String id) throws SQLException {
		PreparedStatement pStatement = con.prepareStatement("SELECT * FROM teacher WHERE tid = ?"); 
		pStatement.setString(1, id);
		ResultSet resultSet = pStatement.executeQuery();
		
		Teacher t = null;
		if( resultSet.next()) {
			t = mapping(resultSet);
			//t = new Teacher(resultSet.getString("tid"), resultSet.getString("tname"), resultSet.getString("status"));
		}
		return t;
	}
	
	public ArrayList<Teacher> findAll() throws SQLException {
		PreparedStatement pStatement = con.prepareStatement("SELECT * FROM teacher"); 
		ResultSet resultSet = pStatement.executeQuery();
		
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		while(resultSet.next()) {
			//Teacher t = new Teacher(resultSet.getString("tid"), resultSet.getString("tname"), resultSet.getString("status"));
			Teacher t = mapping(resultSet);
			list.add(t);
		}
		
		return list;
	}
	
	public void save(Teacher t) throws SQLException {
        PreparedStatement pStatement = con.prepareStatement("insert into registration.teacher (tname, status) values (?, ?)"); 
        pStatement.setString(1, t.getTeacherName());
        pStatement.setString(2, t.getStatus());
        pStatement.executeUpdate();
	}
	
	public void save(Teacher t, String id) throws SQLException {	// Update
		PreparedStatement pStatement = con.prepareStatement("update registration.teacher set tname=?, status=? where tid = ?"); 
        pStatement.setString(1, t.getTeacherName());
        pStatement.setString(2, t.getStatus());
        pStatement.setString(3, id);
        pStatement.executeUpdate();
	}
	
	public void delete(String id) throws SQLException {	// remove
		PreparedStatement pStatement = con.prepareStatement("delete from registration.teacher where tid = ?"); 
        pStatement.setString(1, id);
        pStatement.executeUpdate();
	}
	
	public void closeConnect() throws SQLException {
		con.close();
	}
	

	public static void main(String[] args) {
		try {
			TeacherDAO dao = new TeacherDAO();
			dao.delete("7");
//			Teacher kong = new Teacher("","คมสัน","m");
//			dao.save(kong);
//			
//			Teacher beam = new Teacher("","บีม","s");		// Overloading
//			dao.save(beam, "4");
//			
//			Teacher t = dao.findOne("2");
//			System.out.println(t.getTeacherName() + " " + t.getStatus());
//			
//			ArrayList<Teacher> list = dao.findAll();
//			for(Teacher teacher : list) {
//				System.out.println(teacher.getTeacherName());
//			}
			
			dao.closeConnect();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
