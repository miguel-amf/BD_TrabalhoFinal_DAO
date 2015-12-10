package bd_final;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

class InterfaceGrafica implements ActionListener {
	
	JFrame frame, frameBusca;
	
	
	PessoaPane pessoaPane;
	LoginPane loginPane;
	BuscaPessoa buscaPessoa;
	BuscaAtendimento buscaAtendimento;
	ACreatePane	aCreatePane;
	
	public void inicializaInterface() {
		
		/*Troca as fontes de todos os objetos*/
		setUIFont(new FontUIResource(new Font("Verdana", 0, 16)));
		
		
		/*Cria o frame principal*/
		frame = new JFrame("UTI Neonatal Vicente Pires");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300, 180);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		/*inicializa painéis*/
		
		loginPane = new LoginPane();
		JPanel curPane = loginPane.create();
		
		/*Iniciando listeners*/
		loginPane.botaoLogin.addActionListener(this);
		loginPane.fieldUsuario.addActionListener(this);
		loginPane.fieldSenha.addActionListener(this);
		

		
		
		
		/*inicializa o frame*/
		frame.setContentPane(curPane);
		frame.setVisible(true);
		
		
	}	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {	
		
		/*verifica se o evento "e" foi disparado pelo campo password ou usuario do login*/
		if(e.getSource() == loginPane.fieldSenha || e.getSource() == loginPane.fieldUsuario) {
			/*Simula um click no botao login*/
			loginPane.botaoLogin.doClick();
		}
		
		
		
		
		
		/*verifica se o evento "e" foi disparado pelo botao login*/
		if(e.getSource() == loginPane.botaoLogin) {
			/*joga os valores dos campos em variaveis*/
			String login = loginPane.fieldUsuario.getText();
			char[] password = loginPane.fieldSenha.getPassword();
			
			/*verifica se os campos estao preenchidos*/
			if (login.isEmpty() || password.length == 0)  {
				JOptionPane.showMessageDialog(frame, "Complete ambos os campos", "Erro no Login", JOptionPane.ERROR_MESSAGE);
				
				/*apaga os campos e coloca o foco no campo usuario*/
				loginPane.fieldSenha.setText("");
				loginPane.fieldUsuario.setText("");
				loginPane.fieldUsuario.requestFocus();
				
			} else {
				/*realiza o login e verifica se foi bem sucedido*/
				if (Dao.login(login, String.valueOf(password)) ==  false) {
					JOptionPane.showMessageDialog(frame, "Dados incorretos. Verifique os dados inseridos", "Erro no Login", JOptionPane.ERROR_MESSAGE);
					
					/*apaga os campos e coloca o foco no campo usuario*/
					loginPane.fieldSenha.setText("");
					loginPane.fieldUsuario.setText("");
					loginPane.fieldUsuario.requestFocus();
				} else {
					/*gera o novo pane*/
					frame.setContentPane(tabPane());
					frame.setSize(630, 390);
					frame.setLocationRelativeTo(null);
					frame.revalidate();
					
					
					/*Cria o frame de busca*/
					frameBusca = new JFrame("Busca");
					frameBusca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					frameBusca.setSize(450, 600);
					frameBusca.setResizable(false);
					frameBusca.setLocationRelativeTo(frame);
					
					frameBusca.setContentPane(tabBusca());
					frameBusca.setVisible(true);
					
					
				}	
			}
		}
		
		
		if(e.getSource() == pessoaPane.botaoCadastro) {			
					
			/*Constroi a querry*/
			
			String func = "inserirpaciente(";
			
			if (pessoaPane.checkF.isSelected()) {
				func += "'F'";
			} else {
				func += "'M'";
			}
			func += ", '";
			
			
			func += pessoaPane.fieldNome.getText() + "', '";
			
			func += pessoaPane.fieldBairro.getText() + "', '";
			
			func += pessoaPane.fieldRua.getText() + "', '";
			
			func += "1990-01-01" + "', '";
			
			func += pessoaPane.fieldTelefone.getText()  + "', '";
			
			func += pessoaPane.fieldCpf.getText().replace(".", "").replace("-", "") + "', '";
			
			func += pessoaPane.tipoSangue.getSelectedItem() + "');";
				
			boolean deuBao = true;
			try {
				Dao.exeFuncao(func);
			} catch (SQLException e1) {
				e1.printStackTrace();
				deuBao = false;
				JOptionPane.showMessageDialog(frame, "Erro ao inserir pessoa :(", "PostgreSQL", JOptionPane.ERROR_MESSAGE);
				
			}
			if (deuBao) {
				JOptionPane.showMessageDialog(frame, "Pessoa inserida com sucesso!", "PostgreSQL", JOptionPane.INFORMATION_MESSAGE);
			}	
		}
		
		
		
		if(e.getSource() == buscaPessoa.botaoBusca) {
			buscaPessoa.textResultado.setText("");
			ResultSet resultado = null;
			try {
				/*Cria o resultset para fazer treitas*/
				resultado = Dao.retrieve("pessoa", "*", "nome LIKE '%" + buscaPessoa.fieldPessoa.getText() + "%'");

				buscaPessoa.textResultado.append("ID\tNOME\n");
				
				while(resultado.next()) {
					buscaPessoa.textResultado.append(resultado.getString(resultado.findColumn("idpessoa")) + "\t" + resultado.getString(resultado.findColumn("nome")) + "\n");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
		
		if(e.getSource() == buscaAtendimento.botaoBusca) {
			buscaAtendimento.textResultado.setText("");
			ResultSet resultado = null;
			try {
				/*Cria o resultset para fazer treitas*/
				resultado = Dao.retrieve("atendimento", "*", "idpaciente = " + buscaAtendimento.fieldId.getText());


				while(resultado.next()) {
					buscaAtendimento.textResultado.append("################################\n");
					//buscaPessoa.textResultado.append("Nome: " + Dao.retrieve("pessoa", "*", "idpessoa = " + resultado.getString(4)).getString(2) + "\n");
					buscaAtendimento.textResultado.append("id atendimento: " + resultado.getString(1));
					buscaAtendimento.textResultado.append(" data: " + resultado.getString(2) + "\n");
					buscaAtendimento.textResultado.append("Resultado: \n" + resultado.getString(6) + "\n");
					buscaAtendimento.textResultado.append("################################\n");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		if(e.getSource() == aCreatePane.botaoCriar) {

			/*Constroi a querry*/
			
			String value = "'";
			
			value += aCreatePane.fieldData.getText() + " " + aCreatePane.fieldHora.getText() + "', ";
			
			value += aCreatePane.tipoAtendimento.getSelectedItem().toString().substring(0,1) + ", ";
			
			value += aCreatePane.fieldId.getText() + ", ";
			
			value += "'00:00:00', 'Sem Resultado', 932";
			
			
			
			boolean deuBao = true;
			try {
				Dao.create("atendimento(dataatendimento, idtipoatendimento, idpaciente, duracaoatendimento,resultado,umatendimento)", value);
			} catch (SQLException e1) {
				e1.printStackTrace();
				deuBao = false;
				JOptionPane.showMessageDialog(frame, "Erro ao inserir atendimento :(", "PostgreSQL", JOptionPane.ERROR_MESSAGE);
				
			}
			if (deuBao) {
				JOptionPane.showMessageDialog(frame, "Atendimento inserido com sucesso!", "PostgreSQL", JOptionPane.INFORMATION_MESSAGE);
			}	
			
		}
	}/*Fim listener*/



	private JComponent tabPane() {
		
		JTabbedPane pane = new JTabbedPane();
		
		/*insere painel pessoa*/
		pessoaPane = new PessoaPane();
		pane.addTab("Cadastro", pessoaPane.create());
		pessoaPane.botaoCadastro.addActionListener(this);
		
		aCreatePane = new ACreatePane();
		pane.addTab("Criar Atendimento", aCreatePane.create());
		aCreatePane.botaoCriar.addActionListener(this);
		
		
		
		return pane;
		
	}
	
	private JComponent tabBusca() {
		JTabbedPane pane = new JTabbedPane();
		
		/*insere painel buscaPessoa*/
		buscaPessoa = new BuscaPessoa();
		pane.addTab("Pessoa", buscaPessoa.create());
		buscaPessoa.botaoBusca.addActionListener(this);
		buscaAtendimento = new BuscaAtendimento();
		pane.addTab("Atendimento", buscaAtendimento.create());
		buscaAtendimento.botaoBusca.addActionListener(this);
		
		return pane;
	}
	
    public static void setUIFont(FontUIResource f) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }
}