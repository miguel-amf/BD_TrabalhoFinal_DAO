package bd_final;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class ACreatePane {
	
	JLabel labelId;
	JLabel labelData;
	JLabel labelHora;
	JLabel labelTipo;
	
	JTextField fieldId;
	JFormattedTextField fieldData;
	JFormattedTextField fieldHora;
	
	JComboBox tipoAtendimento;
	
	JButton botaoCriar;
	


	public JPanel create() {
		JPanel paneCriarAt = new JPanel(new GridBagLayout());
		
		
		/*Criando as mascaras para os campos formatados*/
		MaskFormatter maskData = null;
		MaskFormatter maskHora = null;
		
		try {
			maskData = new MaskFormatter("####-##-##");
			maskHora = new MaskFormatter("##:##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		maskData.setPlaceholderCharacter('x');
		maskHora.setPlaceholderCharacter('0');
		
		/*Criando os labels*/
		
		labelId = new JLabel("Id Pessoa: ");
		labelData = new JLabel("Data: ");
		labelHora = new JLabel("Hora: ");
		labelTipo = new JLabel("Tipo Atendimento: ");
		
		fieldId = new JTextField();
		
		fieldData = new JFormattedTextField(maskData);
		fieldHora = new JFormattedTextField(maskHora);
		
		botaoCriar = new JButton("Criar");
		
		
		
		/*Configs dos componentes*/
		try {
			povoaCombobox();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.ipady = 10;
		c.ipadx = 20;
		
		
		/*Desenhando os Componentes*/
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		paneCriarAt.add(labelId, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		paneCriarAt.add(labelData, c);

		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		paneCriarAt.add(labelHora, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		paneCriarAt.add(fieldId, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		paneCriarAt.add(fieldData, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		paneCriarAt.add(fieldHora, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		paneCriarAt.add(tipoAtendimento, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		paneCriarAt.add(botaoCriar, c);
		
		
		
		
		return paneCriarAt;
	}



	private void povoaCombobox() throws SQLException{
		ResultSet rs = Dao.retrieve("tipoatendimento", "COUNT(*)", "true");
		rs.next();
		System.out.println(rs.getString(1));

		String[] values = new String[Integer.parseInt(rs.getString(1))];
		
		rs = Dao.retrieve("tipoatendimento", "*", "true");
		
		int i = 0;
		while (rs.next()) {
			values[i] = rs.getString(1) + ". " + rs.getString(2);
			i++;
		}
		
		tipoAtendimento = new JComboBox<String>(values);
		
		
	}
	
}