package bd_final;

import java.sql.*;

// Data Access Object da classe Pessoa referente a tabela Pessoa
public class PessoaDAO {
	public PessoaDAO(){
		@SuppressWarnings("unused")
		Banco banco = new Banco();
	} 
	
	// Função que retorna todas as pessoas da tabela Pessoa e todas as suas informações
	public Pessoa consultaPessoa(){
		
		Pessoa pes = new Pessoa();
		
		try {
			
			Connection conn = Banco.getConexao();
			Statement st = conn.createStatement();
			
			ResultSet res = st.executeQuery("SELECT * FROM pessoa");
	
			while(res.next()){
				pes.setId(res.getInt("idpessoa"));
				pes.setCpf(res.getString("cpf"));
				pes.setTelefone(res.getString("telefone"));
				pes.setTipo(res.getInt("tipo"));
				pes.setDatanasc(res.getString("datanasc"));
				pes.setRua(res.getString("rua"));
				pes.setBairro(res.getString("bairro"));
				pes.setNome(res.getString("nome"));
				pes.setSexo(res.getString("sexo"));
				imprimePessoa(pes);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu conectar ao banco de dados.");
		}
		
		return pes;
	}
	
	// Função que recebe uma pessoa de algum lugar e insere no banco, ignora o id pois é serial..
	public void inserePessoa(Pessoa pes){
		
		try {
			
			Connection conn = Banco.getConexao();
			Statement st = conn.createStatement();
			String SQL = "INSERT INTO pessoa(cpf, telefone, tipo, datanasc, rua, bairro, nome, sexo)"
					+ "VALUES ('" + pes.getCpf() + "','" + pes.getTelefone() + "'," + pes.getTipo() +",'" + pes.getDatanasc() 
					+ "','" + pes.getRua() + "','" + pes.getBairro() + "','" + pes.getNome()  + "','" + pes.getSexo() + "');";
			
			st.executeQuery(SQL);
			
			System.out.println("Inserção feita com sucesso.");
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu conectar ao banco de dados.");
		}
	}
	
	// Recebe uma pessoa e deleta por meio do id. 
	public void deletePessoa(Pessoa pes){
		try {
			
			Connection conn = Banco.getConexao();
			Statement st = conn.createStatement();
			String SQL = "DELETE FROM pessoa WHERE idpessoa = " + pes.getId() + ";";
			st.executeUpdate(SQL);
			st.close();
			System.out.println("Deleteu com sucesso.");
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu conectar ao banco de dados.");
		}
		
	}
	
	// Imprime informações referentes a uma instancia de pessoa
	private void imprimePessoa(Pessoa pes) {
		System.out.println("ID: " + pes.idpessoa);
		System.out.println("CPF: " + pes.cpf);
		System.out.println("Nome: " + pes.nome);
		System.out.println("Sexo: " + pes.sexo);
		System.out.println("Telefone: "+ pes.telefone);
		System.out.println("TIPO: " + pes.tipo);
		System.out.println("Endereço: " + pes.bairro + " " + pes.rua);

	}
}
