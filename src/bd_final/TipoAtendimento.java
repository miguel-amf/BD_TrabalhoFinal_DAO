package bd_final;

import java.sql.SQLException;

public class TipoAtendimento {
	public TipoAtendimento(){
	}
	
	public TipoAtendimento(int idtipoatendimento, String descratendimento){
		//this.setIdatendimento(idatendimento);
		this.setDescratendimento(descratendimento);
	}
	

	String descratendimento;
	int idtipoatendimento;
	
	public int getIdtipoatendimento () {
		return idtipoatendimento;
	}
	
	public void setIdtipoatendimento (int tipo) {
		idtipoatendimento = tipo;
	}

	public String getDescratendimento(){
		return descratendimento;
	}
	
	public void setDescratendimento(String descratendimento2){
		descratendimento = descratendimento2;
	}
	
	public void insertInDB () throws SQLException{
		Dao.create("tipoatendimento",
								String.valueOf(idtipoatendimento) +", "+
								descratendimento);
	}
}
