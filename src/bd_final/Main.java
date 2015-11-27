package bd_final;

import java.sql.*;

class Main {

	public static void main(String[] args) throws SQLException {

		ResultSet rs = null;
		
		/*faz o login*/
		Dao.login("postgres", "123qwe");
		
		
		rs = Dao.read("pessoa", "*");
		
		while(rs.next()) {
			System.out.println(rs.getString(rs.findColumn("nome")));
		}
		
		
		/*fechando a conexao*/
		rs.close();
		Dao.close();
		

	}
}