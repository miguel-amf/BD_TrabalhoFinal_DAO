package bd_final;

import java.awt.*;
import javax.swing.*;

class InterfaceGrafica {
	
	
	public void inicializaInterface() {
		
		JFrame frameLogin = new JFrame("Login");
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameLogin.setSize(400, 200);
		frameLogin.setResizable(false);
		frameLogin.setLocationRelativeTo(null);
		
		
		JPanel paneLogin = new JPanel(new GridBagLayout());
		GridBagConstraints l = new GridBagConstraints();
		
		l.fill = GridBagConstraints.HORIZONTAL;
		l.weightx = 0.5;
		
		/*criando componentes*/
		JButton botaoLogin = new JButton("Login");
		
		JLabel textUsuario = new JLabel("Usuário");
		JLabel textSenha = new JLabel("Senha");
		JLabel labelgordo = new JLabel("         ");
		
		JTextField fieldUsuario = new JTextField();
		JPasswordField fieldSenha = new JPasswordField();
		
		/*Configurando componentes*/
		
		
		
		/*desenhando componentes*/
		
		l.gridx = 0;
		l.gridy = 0;
		paneLogin.add(textUsuario, l);
		
		l.gridx = 0;
		l.gridy = 1;
		l.gridwidth = 3;
		paneLogin.add(fieldUsuario, l);
		
		l.gridx = 0;
		l.gridy = 2;
		l.gridwidth = 1;
		paneLogin.add(textSenha, l);
		
		l.gridx = 0;
		l.gridy = 3;
		l.gridwidth = 3;
		paneLogin.add(fieldSenha, l);
		
		l.gridx = 2;
		l.gridy = 4;
		l.gridwidth = 1;
		paneLogin.add(botaoLogin, l);
		
		l.gridx = 1;
		l.gridy = 0;
		paneLogin.add(labelgordo, l);
		
		
		
		
		
		
		
		/*Adiciona componentes*/
		
		frameLogin.setContentPane(paneLogin);
		frameLogin.setVisible(true);
		
		
		
	}
}