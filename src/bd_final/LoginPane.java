package bd_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPane {
	
	JButton botaoLogin;
	
	JLabel textUsuario;
	JLabel textSenha;
	
	JTextField fieldUsuario;
	JPasswordField fieldSenha;
	
	
	public JPanel create() {
		

		
		JPanel paneLogin = new JPanel(new GridBagLayout());
		GridBagConstraints l = new GridBagConstraints();
		
		l.fill = GridBagConstraints.HORIZONTAL;
		l.weightx = 0.5;
		
		/*criando componentes*/
		botaoLogin = new JButton("Login");
		
		textUsuario = new JLabel("Usuário");
		textSenha = new JLabel("Senha");
		JLabel labelgordo = new JLabel("         ");
		
		fieldUsuario = new JTextField();
		fieldSenha = new JPasswordField();
		
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
		
		
		return paneLogin;
		
	}
}