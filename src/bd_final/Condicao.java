package bd_final;

//Classe referente a tabela Funcionário
public class Condicao {
	public Condicao(){
	}
	
	//Construtor da classe
	public Condicao(int codcondicao, String descrcondicao){
		this.setCodcondicao(codcondicao);
		this.setDescrcondicao(descrcondicao);
		
	}
	
	int codcondicao;
	String descrcondicao;
	
	public int getCodcondicao(){
		return codcondicao;
	}
	
	public void setCodcondicao(int codcondicao2) {
		codcondicao = codcondicao2;
	}
	
	public String getDescrcondicao(){
		return descrcondicao;
	}
	
	public void setDescrcondicao(String descrcondicao2) {
		descrcondicao = descrcondicao2;
	}

}