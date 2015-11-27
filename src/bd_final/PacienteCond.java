package bd_final;

import java.sql.SQLException;

public class PacienteCond {
	public PacienteCond(){
	}

	public PacienteCond(int idpaciente, int codcondicao){
		//this.setId(idpaciente);
		this.setCodcondicao(codcondicao);
	}
	
	int codcondicao;
	int idpaciente;
	
	public int getCodcondicao(){
		return codcondicao;
	}
	
	public void setCodcondicao(int codcondicao2) {
		codcondicao = codcondicao2;
	}
	
	public int getIdpaciente(){
		return idpaciente;
	}
	
	public void setIdpaciente(int idpaciente2) {
		idpaciente = idpaciente2;
	}
	
	public void insertInDB () throws SQLException{
		Dao.create("pacientecond",
								String.valueOf(codcondicao) +", "+
								String.valueOf(idpaciente));
	}
}