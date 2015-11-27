package bd_final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class InterfaceGrafica implements ActionListener {
	
	
	public void inicializaInterface() {
		
		/*Cria o frame*/
		JFrame frame = new JFrame("UTI Neonatal Vicente Pires");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(600, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		
		JTabbedPane painelPrincipal = new JTabbedPane();
		
		painelPrincipal.addTab("Login", loginPanel());
		painelPrincipal.addTab("Cadastro", pessoaPanel());
		
		
		
		
		/*inicializa o frame*/
		frame.setContentPane(painelPrincipal);
		frame.setVisible(true);
		
		
		
	}
	
	public JPanel pessoaPanel() {
		JPanel panePessoa = new JPanel(new GridBagLayout());
		
		/*Criando os labels*/
		
		JLabel labelNome = new JLabel("Nome: ");
		JLabel labelCpf = new JLabel("CPF: ");
		JLabel labelRua = new JLabel("Rua: ");
		JLabel labelTipoSangue = new JLabel("Tipo Sanguíneo: ");
		JLabel labelSexo = new JLabel("Sexo: ");
		JLabel labelTelefone = new JLabel("Telefone: ");
		JLabel labelBairro = new JLabel("Bairro: ");
		JLabel labelSexF = new JLabel("F");
		JLabel labelSexM = new JLabel("M");
		
		JTextField fieldNome = new JTextField();
		JTextField fieldCpf = new JTextField();
		JTextField fieldRua = new JTextField();
		JTextField fieldTelefone = new JTextField();
		JTextField fieldBairro = new JTextField();
		
		JCheckBox checkF = new JCheckBox();
		JCheckBox checkM = new JCheckBox();
		
		JButton botaoCadastro = new JButton("Cadastrar");
		
		JComboBox tipoSangue = new JComboBox();
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		/*Desenhando os Componentes*/
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panePessoa.add(labelNome, c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 4;
		panePessoa.add(labelSexo, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panePessoa.add(fieldNome, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		panePessoa.add(labelSexM, c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		panePessoa.add(checkM, c);
		
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		panePessoa.add(labelSexF, c);
		
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		panePessoa.add(checkF, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		panePessoa.add(labelCpf, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 4;
		panePessoa.add(labelTelefone, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		panePessoa.add(fieldCpf, c);
		
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 4;
		panePessoa.add(fieldTelefone, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		panePessoa.add(labelRua, c);
		
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 4;
		panePessoa.add(labelBairro, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		panePessoa.add(fieldRua, c);
		
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 4;
		panePessoa.add(fieldBairro, c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		panePessoa.add(labelTipoSangue, c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		panePessoa.add(tipoSangue, c);
		
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		panePessoa.add(botaoCadastro, c);
		
		
		botaoCadastro.addActionListener(this);
		
		
		return panePessoa;
	}
	
	
	public JPanel loginPanel() {
		
		
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
		
		
		
		
		
		
		
		/*Adiciona os listeners*/
		
		botaoLogin.addActionListener(this);
		
		
		return paneLogin;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print(e.getSource().toString() + "\n");
		
	}
}