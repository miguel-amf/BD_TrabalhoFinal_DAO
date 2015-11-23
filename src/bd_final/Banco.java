package bd_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Classe para conexão ao banco de dados
public class Banco {
	private static String url = "jdbc:postgresql://localhost:5432/TrabalhoBD";
	private static Properties props = new Properties();
	private static Connection conn;
	
	public Banco() {
		
		props.setProperty("user", "postgres");
		props.setProperty("password", "123qwe");
	
	}
	
	// Função para conectar ao banco de dados
	public static Connection getConexao(){
		
		try {
			conn = DriverManager.getConnection(url, props);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problemas ao abrir conexão com o banco de dados.");
		}
		
		return conn;
	}
}


