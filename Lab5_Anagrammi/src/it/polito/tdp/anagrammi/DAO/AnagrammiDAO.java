package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammiDAO {
	
	public boolean isCorrect (String anagramma) {
		
		final String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=secret";
		
		final String sql = "SELECT nome " +
				   		   "FROM parola " +
				   		   "WHERE nome = ?";
		
		try {	
			
			Connection conn = DriverManager.getConnection(jdbcURL);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet res = st.executeQuery();

		if (res.next()) 
			return true;
	
		conn.close();
	
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	
		return false;
	}
	
}
