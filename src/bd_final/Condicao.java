package bd_final;

import java.sql.SQLException;

//Classe referente a tabela Funcionário
public class Condicao {
	
	int codcondicao;
	String descrcondicao;
	
	
	public Condicao(){
	}
	
	//Construtor da classe
	public Condicao(int codcondicao, String descrcondicao){
		this.setCodcondicao(codcondicao);
		this.setDescrcondicao(descrcondicao);
		
	}
	
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
	
	public void insertInDB () throws SQLException{
		Dao.create("condicao", descrcondicao);
	}

}