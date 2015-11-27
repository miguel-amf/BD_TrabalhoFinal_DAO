package bd_final;

public class UnidadeMedica {
	public UnidadeMedica(){
	}
	
	public UnidadeMedica(int idum, int codtipoum, String nomeum, String telefoneum, 
							String bairroum, String ruaum){
		this.setIdUm(idum);
		this.setTipoUm(codtipoum);
		this.setNomeUm(nomeum);
		this.setTelefoneUm(telefoneum);
		this.setBairroUm(bairroum);
		this.setRuaUm(ruaum);
	}
	
	int idum;
	int codtipoum;
	String nomeum;
	String telefoneum;
	String bairroum;
	String ruaum;
	
	public String getTelefoneUm(){
		return telefoneum;
	}
	
	public void setTelefoneUm(String telefoneum2) {
		telefoneum = telefoneum2;	
	}

	public String getRuaUm(){
		return ruaum;
	}
	
	public void setRuaUm(String ruaum2) {
		ruaum = ruaum2;
	}
	
	public String getBairroUm(){
		return bairroum;
	}
	
	public void setBairroUm(String bairroum2) {
		bairroum = bairroum2;
	}
	
	public String getNomeUm(){
		return nomeum;
	}
	
	public void setNomeUm(String nomeum2) {
		nomeum = nomeum2;
	}
	
	public int getTipoUm(){
		return codtipoum;
	}
	
	public void setTipoUm(int codtipoum2) {
		codtipoum = codtipoum2;
	}
	
	public int getIdUm(){
		return idum;
	}
	
	public void setIdUm(int idum2) {
		idum = idum2;
	}
	
}
