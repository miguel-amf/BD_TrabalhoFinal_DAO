package bd_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PessoaPane {
	
	JLabel labelNome;
	JLabel labelCpf;
	JLabel labelRua;
	JLabel labelTipoSangue;
	JLabel labelSexo;
	JLabel labelTelefone;
	JLabel labelBairro;
	JLabel labelSexF;
	JLabel labelSexM;
	
	JTextField fieldNome;
	JFormattedTextField fieldCpf;
	JTextField fieldRua;
	JFormattedTextField fieldTelefone;
	JTextField fieldBairro;
	
	JCheckBox checkF;
	JCheckBox checkM;
	
	JButton botaoCadastro;
	
	JComboBox tipoSangue;

	public JPanel create() {
		JPanel panePessoa = new JPanel(new GridBagLayout());
		
		
		/*Criando as mascaras para os campos formatados*/
		MaskFormatter maskCpf = null;
		MaskFormatter maskTel = null;
		
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			maskTel = new MaskFormatter("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		maskCpf.setPlaceholderCharacter('_');
		maskTel.setPlaceholderCharacter('_');
		
		/*Criando os labels*/
		
		labelNome = new JLabel("Nome: ");
		labelCpf = new JLabel("CPF: ");
		labelRua = new JLabel("Rua: ");
		labelTipoSangue = new JLabel("Tipo Sanguíneo: ");
		labelSexo = new JLabel("Sexo: ");
		labelTelefone = new JLabel("Telefone: ");
		labelBairro = new JLabel("Bairro: ");
		labelSexF = new JLabel("F");
		labelSexM = new JLabel("M");
		
		fieldNome = new JTextField();
		fieldCpf = new JFormattedTextField(maskCpf);
		fieldRua = new JTextField();
		fieldTelefone = new JFormattedTextField(maskTel);
		fieldBairro = new JTextField();
		
		checkF = new JCheckBox();
		checkM = new JCheckBox();
		
		botaoCadastro = new JButton("Cadastrar");
		
		tipoSangue = new JComboBox();
		
		
		
		
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
		c.ipadx = 200;
		panePessoa.add(botaoCadastro, c);
		
		return panePessoa;
	}
	
}