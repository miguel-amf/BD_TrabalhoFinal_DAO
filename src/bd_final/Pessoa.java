package bd_final;

import java.sql.SQLException;

//Classe referente a tabela Pessoa
public class Pessoa {

	public Pessoa(){
	}
	
	//Construtor(?) da classe
	public Pessoa(int idpessoa, String cpf, String telefone, 
				int tipo, String datanasc, String rua, 
				String bairro, String nome, String sexo){
			
		this.setId(idpessoa);
		this.setCpf(cpf);
		this.setTelefone(telefone);
		this.setTipo(tipo);
		this.setDatanasc(datanasc);
		this.setRua(rua);
		this.setBairro(bairro);
		this.setNome(nome);
		this.setSexo(sexo);
			
	}
	
	int idpessoa;
	int tipo;
	String cpf;
	String telefone;
	String datanasc;
	String rua;
	String bairro;
	String nome;
	String sexo;
	
	// Gets e sets da classe
	public void setId(int idpessoa2) {
		idpessoa = idpessoa2;
	}
	
	public int getId() {
		return idpessoa;
	}
	
	public void setTipo(int tipo2) {
		tipo = tipo2;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setCpf(String cpf2) {
		cpf = cpf2;	
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setDatanasc(String datanasc2) {
		datanasc = datanasc2;	
	}
	
	public String getDatanasc() {
		return datanasc;
	}
	
	public void setTelefone(String telefone2) {
		telefone = telefone2;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setRua(String rua2) {
		rua = rua2;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setBairro(String bairro2) {
		bairro = bairro2;	
	}
	
	public String getBairro() {
		return bairro;	
	}
	
	public void setNome(String nome2) {
		nome = nome2;
	}

	public String getNome(){
		return nome;
	}
	
	public void setSexo(String sexo2) {
		sexo = sexo2;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void insertInDB () throws SQLException{
		Dao.create("pessoa",
								sexo +", "+
								nome +", "+
								bairro +", "+
								rua +", "+
								datanasc +", "+
								String.valueOf(tipo) +", "+
								telefone +", "+
								cpf +", "+
								String.valueOf(idpessoa)
								);
	}
}
