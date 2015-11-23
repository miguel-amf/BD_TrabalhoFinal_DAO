package bd_final;

public class TipoUnidadeMedica extends UnidadeMedica {
	public TipoUnidadeMedica(){
	}
	
	public TipoUnidadeMedica(int codtipoum, String descrtipoum){
		this.setTipoUm(codtipoum);
		this.setDescrTipoUm(descrtipoum);
	}
	
	String descrtipoum;
	
	public String getDescrTipoUm(){
		return descrtipoum;
	}
	
	public void setDescrTipoUm(String descrtipoum2) {
		descrtipoum = descrtipoum2;
		
	}

	
}
