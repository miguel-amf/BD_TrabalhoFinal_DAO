package bd_final;

//Classe referente a tabela Paciente
public class Paciente extends Pessoa {
	public Paciente(){
	}
	
	//Construtor da classe
	public Paciente(int idpaciente,int idpessoa, String tiposangue){
		this.setIdPaciente(idpaciente);
		this.setId(idpessoa);
		this.setTipoSangue(tiposangue);
		
	}
	
	int idpaciente;
	String tiposangue;
	
	public int getIdPaciente(){
		return idpaciente;
	}
	
	public void setIdPaciente(int idpaciente2){
		idpaciente = idpaciente2;
	}
	
	public String getTipoSangue(){
		return tiposangue;
	}
	
	public void setTipoSangue(String tiposangue2){
		tiposangue = tiposangue2;
	}
}
