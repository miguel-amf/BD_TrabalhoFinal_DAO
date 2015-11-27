package bd_final;

import java.sql.SQLException;

public class Atendimento extends Paciente {
	public Atendimento(){
	}
	
	public Atendimento(int idatendimento, String dataatendimento, int idtipoatendimento, 
			String resultado, String duracaoatendimento, int umatendimento, int idpaciente){
		
		this.setIdatendimento(idatendimento);
		this.setDataatendimento(dataatendimento);
		this.setIdtipoatendimento(idtipoatendimento);
		this.setResultado(resultado);
		this.setDuracao(duracaoatendimento);
		this.setUnidadeMedica(umatendimento);
		this.setIdPaciente(idpaciente);
		
	}
	
	int idatendimento;
	int idtipoatendimento;
	int umatendimento;
	int idpaciente;
	String dataatendimento;
	String resultado;
	String duracaoatendimento;
	
	public int getUnidadeMedica(){
		return umatendimento;
	}
	
	public void setUnidadeMedica(int umatendimento2) {
		umatendimento = umatendimento2;
	}
	
	public String getDuracao(){
		return duracaoatendimento;
	}
	
	public void setDuracao(String duracaoatendimento2) {
		duracaoatendimento = duracaoatendimento2;
	}
	
	public String getResultado(){
		return resultado;
	}
	
	public void setResultado(String resultado2) {
		resultado = resultado2;
	}
	
	public int getIdtipoatendimento(){
		return idtipoatendimento;
	}
	
	public void setIdtipoatendimento(int idtipoatendimento2) {
		idtipoatendimento = idtipoatendimento2;
	}
	
	public String getDataatendimento(){
		return dataatendimento;
	}
	
	public void setDataatendimento(String dataatendimento2) {
		dataatendimento = dataatendimento2;	
	}
	
	public int getIdatendimento(){
		return idatendimento;
	}
	
	public void setIdatendimento(int idatendimento2) {
		idatendimento = idatendimento2;
	}
	
	public void insertInDB () throws SQLException{
		Dao.create("atendimento", 	dataatendimento 	+", "+
								String.valueOf(idtipoatendimento) +", "+
								String.valueOf(idpaciente) +", "+
								duracaoatendimento +", "+
								resultado +", "+
								umatendimento);
	}
	
}
