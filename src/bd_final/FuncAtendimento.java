package bd_final;

public class FuncAtendimento extends Atendimento {
	public FuncAtendimento(){
	}
	
	public FuncAtendimento(int idatendimento, int matr){
		this.setIdatendimento(idatendimento);
		this.setMatr(matr);
	}

	int matr;
	
	public int getMatr(){
		return matr;
	}
	
	public void setMatr(int matr2) {
		matr = matr2;
	}
	
	
}
