package bd_final;

import java.sql.*;
import java.util.Properties;

class Main {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/TrabalhoBD";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123qwe");
		
		Connection conn;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, props);
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rs = st.executeQuery("SELECT * FROM pessoa");
		
		while(rs.next()) {
			System.out.println(rs.getString(rs.findColumn("nome")));
		}
		
		rs.close();
		st.close();
		

	}

}