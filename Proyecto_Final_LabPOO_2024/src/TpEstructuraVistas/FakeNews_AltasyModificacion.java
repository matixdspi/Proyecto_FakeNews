package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import TpEstructuraModelos.FakeNew;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FakeNews_AltasyModificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTitulo;
	private JTextField textDescripcion;
	private JTextField textCreador;
	private JTextField textFechaApa;

	/**
	 * Create the panel.
	 */
	public FakeNews_AltasyModificacion() {
		CargarComponentes();

	}
	
	public void FakeNews_AltasyModificacion(FakeNew fakenew)
	{
		CargarComponentes();
		Precargar_Objeto(fakenew);
		
		
		
		
	}
	
	
	
	public void CargarComponentes()
	{
		setLayout(null);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(192, 64, 277, 31);
		add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TITULO");
		lblNewLabel.setBounds(305, 36, 46, 14);
		add(lblNewLabel);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(48, 145, 211, 106);
		add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(111, 120, 65, 14);
		add(lblNewLabel_1);
		
		textCreador = new JTextField();
		textCreador.setBounds(48, 312, 211, 40);
		add(textCreador);
		textCreador.setColumns(10);
		
		textFechaApa = new JTextField();
		textFechaApa.setBounds(48, 411, 211, 31);
		add(textFechaApa);
		textFechaApa.setColumns(10);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 486, 89, 23);
		add(btnVolver);
		
		JLabel lblNewLabel_2 = new JLabel("CREADOR");
		lblNewLabel_2.setBounds(102, 287, 73, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FECHA APARICION");
		lblNewLabel_3.setBounds(102, 386, 125, 14);
		add(lblNewLabel_3);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(283, 470, 113, 39);
		add(btnGuardar);
		
		JComboBox comboBoxCategorias = new JComboBox();
		comboBoxCategorias.setBounds(439, 178, 195, 40);
		add(comboBoxCategorias);
		
		JComboBox comboBoxMediosOrigen = new JComboBox();
		comboBoxMediosOrigen.setBounds(439, 341, 195, 40);
		add(comboBoxMediosOrigen);
		
		JLabel lblNewLabel_4 = new JLabel("CATEGORIA");
		lblNewLabel_4.setBounds(502, 153, 73, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MEDIO ORIGEN");
		lblNewLabel_5.setBounds(495, 316, 80, 14);
		add(lblNewLabel_5);
		
	}
	
	
	
	public void Precargar_Objeto(FakeNew fakenew)
	{
		textTitulo.setText(fakenew.getTitulo());
		textDescripcion.setText(fakenew.getDescripcion());
		textFechaApa.setText(fakenew.getFechaApa().toString());
		textCreador.setText(fakenew.getCreador());
		
		
	}
}
