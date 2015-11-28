package bd_final;

import java.sql.*;

class Main {

	public static void main(String[] args) throws SQLException {

		/*
		ResultSet rs = null;
		*/
		
		/*faz o login*/
		/*
		System.out.print(Dao.login("postgres", "123qwe"));
		*/
		/*
		rs = Dao.read("pessoa", "*");
		
		while(rs.next()) {
			System.out.println(rs.getString(rs.findColumn("nome")));
		}
		
		*/
		
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		
		interfaceGrafica.inicializaInterface();
		
		/*
		/*fechando a conexao* /
		rs.close();
		Dao.close();
		*/

	}
}