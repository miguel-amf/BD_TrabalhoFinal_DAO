package bd_final;

public class TipoAtendimento extends Atendimento {
	public TipoAtendimento(){
	}
	
	public TipoAtendimento(int idtipoatendimento, String descratendimento){
		this.setIdatendimento(idatendimento);
		this.setDescratendimento(descratendimento);
	}
	

	String descratendimento;

	public String getDescratendimento(){
		return descratendimento;
	}
	
	public void setDescratendimento(String descratendimento2){
		descratendimento = descratendimento2;
	}
}
