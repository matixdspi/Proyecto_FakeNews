package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class RefutacionRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFechaRefutada;
	private JTextField textFuentes;

	/**
	 * Create the panel.
	 */
	public RefutacionRegistro() {
		setLayout(null);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 487, 89, 23);
		add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(52, 99, 209, 39);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("REFUTADORES");
		lblNewLabel.setBounds(103, 74, 81, 14);
		add(lblNewLabel);
		
		textFechaRefutada = new JTextField();
		textFechaRefutada.setBounds(52, 262, 195, 39);
		add(textFechaRefutada);
		textFechaRefutada.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("FECHA REFUTADA");
		lblNewLabel_1.setBounds(96, 237, 108, 14);
		add(lblNewLabel_1);
		
		textFuentes = new JTextField();
		textFuentes.setBounds(446, 99, 171, 39);
		add(textFuentes);
		textFuentes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FUENTES");
		lblNewLabel_2.setBounds(478, 74, 46, 14);
		add(lblNewLabel_2);
		
		JCheckBox CheckBoxOrganismoOfi = new JCheckBox("ORGANISMO OFICIAL");
		CheckBoxOrganismoOfi.setBounds(446, 262, 149, 39);
		add(CheckBoxOrganismoOfi);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(279, 466, 149, 30);
		add(btnGuardar);

	}
}
