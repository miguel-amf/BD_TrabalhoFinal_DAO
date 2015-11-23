package bd_final;

public class PacienteCond extends Pessoa {
	public PacienteCond(){
	}

	public PacienteCond(int idpaciente, int codcondicao){
		this.setId(idpaciente);
		this.setCodcondicao(codcondicao);
	}
	
	int codcondicao;
	
	public int getCodcondicao(){
		return codcondicao;
	}
	
	public void setCodcondicao(int codcondicao2) {
		codcondicao = codcondicao2;
	}
	
}