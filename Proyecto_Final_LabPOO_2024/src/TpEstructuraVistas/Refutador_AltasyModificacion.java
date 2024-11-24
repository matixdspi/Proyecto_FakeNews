package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraDAOs.RefutadorDAO;
import TpEstructuraModelos.Refutador;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Refutador_AltasyModificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	JComboBox comboBoxMediosOrigen = new JComboBox(mediosVector());
	JButton btnGuardar = new JButton("Guardar");
	
	/**
	 * Create the panel.
	 */
	
	public Refutador_AltasyModificacion(Refutador r) { //si es que recibe datos
		agregarComponentes();
		precargarObjeto(r); //cargar los jtextfield
		btnGuardar.setVisible(false);
		
		JButton botonModificar= new JButton("Modificar");

		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//capturar los datos nuevos
				//llamar al dao y el metodo para modificar
				RefutadorDAO edao = new RefutadorDAO();
				int MedioOrigenNumero = comboBoxMediosOrigen.getSelectedIndex() + 1;
				String MedioOrigenNombre = edao.buscar_MedioOrigenNombre(MedioOrigenNumero);
				Refutador refu = new Refutador(textFieldNombre.getText(),textFieldApellido.getText(), MedioOrigenNombre);
				System.out.println("nombre: " + refu.getNombre() + "apellido: " + refu.getApellido());
				edao.modificacion(r.getApellido(), refu, MedioOrigenNumero);
			}
		});
		botonModificar.setBounds(171, 231, 89, 23);
		add(botonModificar);
		botonModificar.setVisible(true);
	}
	
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
	
	public Refutador_AltasyModificacion() { //en caso de no recibir datos
		agregarComponentes(); // constructor para agregar

	}
	
	public void agregarComponentes() {
		
		
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
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefutadorDAO edao = new RefutadorDAO();
				int MedioOrigenNumero = comboBoxMediosOrigen.getSelectedIndex() + 1;
				String MedioOrigenNombre = edao.buscar_MedioOrigenNombre(MedioOrigenNumero);
				Refutador refu = new Refutador(textFieldNombre.getText(),textFieldApellido.getText(), MedioOrigenNombre);
				System.out.println("nombre: " + refu.getNombre() + "apellido: " + refu.getApellido());
				edao.altas(refu, MedioOrigenNumero);
			}
		});
		btnGuardar.setBounds(317, 247, 89, 23);
		add(btnGuardar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new RefutadorMenu());
				frame.setVisible(true);
			}
		});
		btnVolver.setBounds(30, 247, 89, 23);
		add(btnVolver);
		

		comboBoxMediosOrigen.setBounds(262, 118, 142, 29);
		add(comboBoxMediosOrigen);
		
		
	}
}
