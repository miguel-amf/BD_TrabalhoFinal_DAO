package bd_final;

//Classe referente a tabela Funcionário
public class Funcionario extends Pessoa {
	public Funcionario(){
	}
	
	//Construtor da classe
	public Funcionario(int matr,int idpessoa, int iddep, String foto, String crm, 
			String titulo, String salario, String datainit){
		this.setMatricula(matr);
		this.setId(idpessoa);
		this.setFoto(foto);
		this.setCrm(crm);
		this.setTitulo(titulo);
		this.setSalario(salario);
		this.setDatainit(datainit);
		
	}
	
	int matr;
	int idpessoa;
	int iddep;
	String foto;
	String crm;
	String titulo;
	String salario;
	String datainit;
	
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
}
