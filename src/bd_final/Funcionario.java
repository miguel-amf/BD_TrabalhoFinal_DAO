package bd_final;

import java.sql.SQLException;

//Classe referente a tabela Funcionário
public class Funcionario {
	
	int matr;
	int idpessoa;
	int iddep;
	String foto;
	String crm;
	String titulo;
	String salario;
	String datainit;
	
	//Construtor da classe
	public Funcionario(int matr,int idpessoa, int iddep, String foto, String crm, 
			String titulo, String salario, String datainit){
		this.setMatricula(matr);
		this.setFoto(foto);
		this.setCrm(crm);
		this.setTitulo(titulo);
		this.setSalario(salario);
		this.setDatainit(datainit);
		
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo2) {
		titulo = titulo2;	
	}
	
	public String getSalario(){
		return salario;
	}
	
	public void setSalario(String salario2) {
		salario = salario2;	
	}
	
	public String getDatainit(){
		return datainit;
	}
	
	public void setDatainit(String datainit2) {
		datainit = datainit2;
	}
	
	public String getCrm(){
		return crm;
	}
	
	public void setCrm(String crm2) {
		crm = crm2;	
	}
	
	public String getFoto(){
		return foto;
	}
	
	public void setFoto(String foto2) {
		foto = foto2;
	}
	
	public int getMatr(){
		return matr;
	}
	
	public void setMatricula(int matr2) {
		matr = matr2;
	}
	
	/*
	 * 	int matr;
	int idpessoa;
	int iddep;
	String foto;
	String crm;
	String titulo;
	String salario;
	String datainit;
	 */
	
	public void insertInDB () throws SQLException{
		Dao.create("funcionario", 	
								datainit 	+", "+
								salario +", "+
								titulo +", "+
								String.valueOf(iddep) +", "+
								String.valueOf(idpessoa) +", "+
								foto +", "+
								crm);
	}
	
	
}
