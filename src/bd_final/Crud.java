package bd_final;

import java.sql.*;
import java.util.Properties;

class Crud {
	//variaveis internas
	
	static private Connection conn;
	static private Statement st = null;
	
	static private String url = "jdbc:postgresql://localhost:5432/TrabalhoBD";
	
	/*realiza o login*/
	public static void login(String user, String password) {
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		
		try {
			conn = DriverManager.getConnection(url, props);
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	


	/* 
	 * INICIO DAS FUNCOES CRUD
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	/*Create*/
	public static void create(String table, String values) throws SQLException{
		int qtdModificados = 0;

		qtdModificados = st.executeUpdate("INSERT INTO " + table +  " VALUES (" + values + ")");
		
		/*verifica se foi feita alguma alteracao*/
		if (qtdModificados == 0) {
			/*report to pane*/
		}
	}
	
	/*Read*/
	public static ResultSet read(String table, String args) throws SQLException{
		
		return st.executeQuery("SELECT " + args + " FROM " + table);
		
	}
	
	/*Update*/
	public static void update(String table, String column, String value, String cond) throws SQLException{
		
		st.executeUpdate("UPDATE " + table + " SET " + column + " = " + value + " WHERE " + cond);
	}
	
	/*Delete*/
	public static void delete(String table, String cond) throws SQLException{
		st.executeUpdate("DELETE FROM " + table + " WHERE " + cond);
	}
	
	
	
	
	/*fecha as conexoes*/
	public static void close() throws SQLException {
		conn.close();
		st.close();
		
	}
}