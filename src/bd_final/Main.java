package bd_final;

import java.awt.Font;
import java.sql.*;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		
		
		try {
            // Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
			
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		
		
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		
		interfaceGrafica.inicializaInterface();
		
		/*
		/*fechando a conexao* /
		rs.close();
		Dao.close();
		*/

	}
}