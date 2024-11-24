package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraDAOs.RefutadorDAO;
import TpEstructuraModelos.Refutador;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Refutador_AltasyModificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private String test2;
	private JTextField textFieldApellido;
	JComboBox comboBoxMedio = new JComboBox(mediosVector());
	
	/**
	 * Create the panel.
	 */
	
	public String[] mediosVector() {
		String[] medios = new String[3];
		FakeNew_DAO edao = new FakeNew_DAO();
		for (int i = 1; i <= medios.length; i++) {	
			medios[i-1] = edao.buscar_MedioOrigenNombre(i);	
		}
		return medios;
	}
	
	public void precargarObjeto(Refutador r) {

		textFieldNombre.setText(r.getNombre());
		textFieldApellido.setText(r.getApellido());
	}
	
	public Refutador_AltasyModificacion() {
		
		
		setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(121, 104, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(73, 107, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setBounds(73, 147, 46, 14);
		add(lblNewLabel_1);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(121, 144, 86, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refutador refu = new Refutador(textFieldNombre.getText(),textFieldApellido.getText(), null);
				System.out.println("nombre: " + refu.getNombre() + "apellido: " + refu.getApellido());
				RefutadorDAO edao = new RefutadorDAO();
				edao.altas(refu);
			}
		});
		btnGuardar.setBounds(317, 247, 89, 23);
		add(btnGuardar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 247, 89, 23);
		add(btnVolver);
		
		JComboBox comboBoxMedio = new JComboBox();
		comboBoxMedio.setBounds(274, 104, 86, 22);
		add(comboBoxMedio);
		
	}
}
