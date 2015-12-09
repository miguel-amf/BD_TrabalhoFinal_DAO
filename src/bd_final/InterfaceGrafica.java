package bd_final;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

class InterfaceGrafica implements ActionListener {
	
	JFrame frame;
	
	
	PessoaPane pessoaPane;
	LoginPane loginPane;
	
	public void inicializaInterface() {
		
		/*Troca as fontes de todos os objetos*/
		setUIFont(new FontUIResource(new Font("Verdana", 0, 16)));
		
		
		/*Cria o frame*/
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
	}



	private JComponent tabPane() {
		
		JTabbedPane pane = new JTabbedPane();
		
		/*insere painel pessoa*/
		pessoaPane = new PessoaPane();
		pane.addTab("Cadastro", pessoaPane.create());
		pessoaPane.botaoCadastro.addActionListener(this);
		
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