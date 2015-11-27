package bd_final;

import java.sql.SQLException;

public class FuncAtendimento {
	int matr;
	int idatendimento;
	
	
	public FuncAtendimento(int idatendimento, int matr){
		this.setIdatendimento(idatendimento);
		this.setMatr(matr);
	}

	public void setIdatendimento(int idatendimento2) {
		idatendimento = idatendimento2;
		
	}
	
	public int getIdatendimento () {
		return idatendimento;		
	}

	public int getMatr(){
		return matr;
	}
	
	public void setMatr(int matr2) {
		matr = matr2;
	}
	
	
	public void insertInDB () throws SQLException{
		Dao.create("funcatendimento", 	String.valueOf(matr) 	+", "+
										String.valueOf(idatendimento));
	}
	
}
