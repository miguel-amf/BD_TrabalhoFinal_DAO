package bd_final;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BuscaPessoa {
	JLabel labelPessoa;
	JLabel labelResultado;
	
	JTextField fieldPessoa;
	
	JTextArea textResultado;
	
	JButton botaoBusca;
	
	JScrollPane scroll;

	
	public JPanel create(){
		/*Cria o painel*/
		JPanel paneBuscaP = new JPanel(new GridBagLayout());
		
		
		/*inicializa os componentes*/
		labelPessoa = new JLabel("Nome:");
		labelResultado = new JLabel("Resultado:");
		
		fieldPessoa = new JTextField();
		
		textResultado = new JTextArea();
		
		botaoBusca = new JButton("Pesquisar");
		
		/*configura os componentes*/
		
		textResultado.setEditable(false);
		
		scroll = new JScrollPane(textResultado);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.ipady = 10;
		c.ipadx = 20;
		
		
		/*Desenhando os Componentes*/
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		paneBuscaP.add(labelPessoa, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.ipadx = 230;
		paneBuscaP.add(fieldPessoa, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.ipadx = 0;
		paneBuscaP.add(botaoBusca, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.ipady = 400;
		paneBuscaP.add(scroll, c);
		
		
		return paneBuscaP;
	}
}