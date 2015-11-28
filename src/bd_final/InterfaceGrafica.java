package bd_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

class InterfaceGrafica implements ActionListener {
	
	JFrame frame;
	
	
	PessoaPane pessoaPane;
	LoginPane loginPane;
	
	public void inicializaInterface() {
		
		/*Cria o frame*/
		frame = new JFrame("UTI Neonatal Vicente Pires");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300, 150);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		/*inicializa painéis*/
		
		loginPane = new LoginPane();
		JPanel curPane = loginPane.create();
		
		/*Iniciando listeners*/
		loginPane.botaoLogin.addActionListener(this);
		loginPane.fieldUsuario.addActionListener(this);
		loginPane.fieldSenha.addActionListener(this);
		

		
		
		/*
		JTabbedPane painelPrincipal = new JTabbedPane();
		
		painelPrincipal.addTab("Login", loginPane.create());
		painelPrincipal.addTab("Cadastro", pessoaPane.create());
		*/
		
		
		
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
					frame.setSize(600, 250);
					frame.setLocationRelativeTo(null);
					frame.revalidate();
				}
				
				
			}
			
			
			

		}
	}



	private JComponent tabPane() {
		
		JTabbedPane pane = new JTabbedPane();
		pessoaPane = new PessoaPane();
		pane.addTab("Cadastro", pessoaPane.create());
		
		return pane;
		
	}
}