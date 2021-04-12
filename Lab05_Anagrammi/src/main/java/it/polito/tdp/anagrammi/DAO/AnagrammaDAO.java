package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammaDAO {
	
	public boolean contiene (String parola) {
		
		String sql = "SELECT id "
				+ "FROM parola "
				+ "WHERE nome = ? ";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			String parolaScelta = parola;
			st.setString(1, parolaScelta);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Integer i = rs.getInt("id");
				return true;
			}
			conn.close();
			return false;
			
		}catch(SQLException e) {
			return false;
		}
	}

}
