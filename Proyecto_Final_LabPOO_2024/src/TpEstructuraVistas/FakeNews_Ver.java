package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraModelos.FakeNew;
import TpEstructuraModelos.Refutador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class FakeNews_Ver extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTitulo;
	private JTextField textFieldDesc;
	private JTextField textFieldCrea;
	private JTextField textFieldFechaApa;
	private JTextField textFieldMedio;
	private JTextField textFieldCate;
	FakeNew_DAO fa = new FakeNew_DAO();
	/**
	 * Create the panel.
	 */
	

	
	public FakeNews_Ver(FakeNew r) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setBounds(30, 41, 46, 14);
		add(lblNewLabel);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(77, 38, 147, 20);
		add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblDescripcionCompleta = new JLabel("Descripcion Completa:");
		lblDescripcionCompleta.setBounds(30, 81, 122, 14);
		add(lblDescripcionCompleta);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(159, 78, 281, 20);
		add(textFieldDesc);
		
		JLabel lblCreador = new JLabel("Creador:");
		lblCreador.setBounds(30, 120, 46, 14);
		add(lblCreador);
		
		textFieldCrea = new JTextField();
		textFieldCrea.setColumns(10);
		textFieldCrea.setBounds(87, 117, 86, 20);
		add(textFieldCrea);
		
		JLabel lblFechaDeApa = new JLabel("Fecha de aparicion:");
		lblFechaDeApa.setBounds(30, 162, 98, 14);
		add(lblFechaDeApa);
		
		textFieldFechaApa = new JTextField();
		textFieldFechaApa.setColumns(10);
		textFieldFechaApa.setBounds(138, 159, 86, 20);
		add(textFieldFechaApa);
		
		JLabel lblMedio = new JLabel("Medio:");
		lblMedio.setBounds(30, 200, 46, 14);
		add(lblMedio);
		
		textFieldMedio = new JTextField();
		textFieldMedio.setColumns(10);
		textFieldMedio.setBounds(77, 197, 96, 20);
		add(textFieldMedio);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(30, 240, 64, 14);
		add(lblCategoria);
		
		textFieldCate = new JTextField();
		textFieldCate.setColumns(10);
		textFieldCate.setBounds(103, 237, 121, 20);
		add(textFieldCate);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new FakeNews_Menu());
				frame.setVisible(true);
			}
		});
		btnVolver.setBounds(327, 254, 89, 23);
		add(btnVolver);
		CargarFakeNew(r);
	}
	
	public void CargarFakeNew(FakeNew r) {

		String nombreMedio, nombreCate;
		nombreMedio = fa.buscar_MedioOrigenNombre(r.getMedioOrigen());
		nombreCate = fa.buscar_categorianNombre(r.getCategoria());
		
		System.out.println("nombre dentro del metodo: " + r.getTitulo());
		textFieldTitulo.setText(r.getTitulo());
		textFieldDesc.setText(r.getDescripcion());
		textFieldCrea.setText(r.getCreador());
		System.out.println("fecha q le paso al metodo" + r.getFechaApa());
		textFieldFechaApa.setText(r.getFechaApa().toString());
		textFieldMedio.setText(nombreMedio);
		textFieldCate.setText(nombreCate);
	}
}
