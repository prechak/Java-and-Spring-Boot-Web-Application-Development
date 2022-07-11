package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoteDAO {
	
	private Connection con;
	
	public NoteDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.sql.cj.jdbc.Drive"); 		// Connect to db
		con = DriverManager.getConnection("jdbc:mysql://localhost/blueshop?characterEncoding=utf-8","root","P@ssw0rd");
	}
	
	public ArrayList<Note> findAll() throws SQLException{
		ArrayList<Note> result = new ArrayList<Note>();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM NOTE");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Note note = new Note();
			note.setId(rs.getString("id"));
			note.setDetail(rs.getString("detail"));
			result.add(note);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		try {
			NoteDAO dao = new NoteDAO();
			ArrayList<Note> list = dao.findAll();
			for(Note n: list) {
				System.out.println(n.getDetail());
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
