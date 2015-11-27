package bd_final;

import java.sql.SQLException;

//Classe referente a tabela Paciente
public class Paciente {
	public Paciente(){
	}
	
	//Construtor da classe
	public Paciente(int idpaciente,int idpessoa, String tiposangue){
		this.setIdPaciente(idpaciente);
		this.setTipoSangue(tiposangue);
		
	}
	
	private int idpaciente;
	private int idpessoa;
	private String tiposangue;
	
	public int getIdPaciente(){
		return idpaciente;
	}
	
	public void setIdPaciente(int idpaciente2){
		idpaciente = idpaciente2;
	}
	
	public int getIdPessoa(){
		return idpessoa;
	}
	
	public void setIdPessoa(int idpessoa2){
		idpessoa = idpessoa2;
	}
	
	
	public String getTipoSangue(){
		return tiposangue;
	}
	
	public void setTipoSangue(String tiposangue2){
		tiposangue = tiposangue2;
	}
	
	public void insertInDB () throws SQLException{
		Dao.create("paciente",
								tiposangue +", "+
								String.valueOf(idpessoa));
	}
}
