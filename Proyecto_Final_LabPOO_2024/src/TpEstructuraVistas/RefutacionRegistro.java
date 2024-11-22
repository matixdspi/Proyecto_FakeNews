package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraModelos.Refutacion;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class RefutacionRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFechaRefutada;
	private JTextField textFuentes;
	
	JCheckBox CheckBoxOrganismoOfi = new JCheckBox("ORGANISMO OFICIAL");

	/**
	 * Create the panel.
	 */
	
	//ALTAS DE REFUTACIONx
	public RefutacionRegistro() {
		cargarComponentes();

	}
	
	
	
	public void cargarComponentes() {
		
setLayout(null);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 487, 89, 23);
		add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(52, 110, 209, 39);
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
		textFuentes.setBounds(449, 120, 171, 39);
		add(textFuentes);
		textFuentes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FUENTES");
		lblNewLabel_2.setBounds(478, 74, 46, 14);
		add(lblNewLabel_2);
		
		
		CheckBoxOrganismoOfi.setBounds(446, 262, 149, 39);
		add(CheckBoxOrganismoOfi);
		
		
		//BOTON DE ALTAS
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FakeNew_DAO edao = new FakeNew_DAO();
				
				String fuentes = textFuentes.getText().toString();
				LocalDate fechaApa = LocalDate.parse(textFechaRefutada.getText());
				
				
				
				
			}
		});
		btnGuardar.setBounds(279, 466, 149, 30);
		add(btnGuardar);
		
		JButton btnRefutadorMenu = new JButton("REFUTADORES");
		btnRefutadorMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RefutadorMenu menu = new RefutadorMenu();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(menu);

				frame.setVisible(true);
			}
		});
		btnRefutadorMenu.setBounds(571, 470, 108, 26);
		add(btnRefutadorMenu);
		
		JButton btnModificacion = new JButton("MODIFICAR");
		btnModificacion.setBounds(279, 470, 149, 23);
		add(btnModificacion);
		
	}
	
	public void precargarObjetos(Refutacion r)
	{
		textFechaRefutada.setText(r.getFechaRefutada().toString());
		textFuentes.setText(r.getFuentes());
		
		if (r.isOrganismoOficial() == true)
		{
			CheckBoxOrganismoOfi.setEnabled(true);
		}
		else 
		{
			CheckBoxOrganismoOfi.setEnabled(false);
		}
	}
}
