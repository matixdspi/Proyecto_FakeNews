package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraDAOs.RefutadorDAO;
import TpEstructuraModelos.FakeNew;
import TpEstructuraModelos.Refutacion;
import TpEstructuraModelos.Refutador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class FakeNews_Ver extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTitulo;
	private JTextField textFieldDesc;
	private JTextField textFieldCrea;
	private JTextField textFieldFechaApa;
	private JTextField textFieldMedio;
	private JTextField textFieldCate;
	FakeNew_DAO fa = new FakeNew_DAO();
	private JTextField textFechaRefutacion;
	private JTextField textFuentesRefutacion;
	private JTextField textNombreRefutador;
	private JTextField textApellidoRefutador;
	private JTextField textMedioRefutador;
	
	JCheckBox chckbxOrganisOfi = new JCheckBox("Organismo Oficial");
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
		textFieldDesc.setBounds(159, 69, 281, 42);
		add(textFieldDesc);
		
		JLabel lblCreador = new JLabel("Creador:");
		lblCreador.setBounds(30, 141, 46, 14);
		add(lblCreador);
		
		textFieldCrea = new JTextField();
		textFieldCrea.setColumns(10);
		textFieldCrea.setBounds(132, 138, 86, 20);
		add(textFieldCrea);
		
		JLabel lblFechaDeApa = new JLabel("Fecha de aparicion:");
		lblFechaDeApa.setBounds(21, 204, 98, 14);
		add(lblFechaDeApa);
		
		textFieldFechaApa = new JTextField();
		textFieldFechaApa.setColumns(10);
		textFieldFechaApa.setBounds(172, 201, 86, 20);
		add(textFieldFechaApa);
		
		JLabel lblMedio = new JLabel("Medio:");
		lblMedio.setBounds(30, 283, 46, 14);
		add(lblMedio);
		
		textFieldMedio = new JTextField();
		textFieldMedio.setColumns(10);
		textFieldMedio.setBounds(122, 280, 96, 20);
		add(textFieldMedio);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(30, 378, 64, 14);
		add(lblCategoria);
		
		textFieldCate = new JTextField();
		textFieldCate.setColumns(10);
		textFieldCate.setBounds(122, 375, 121, 20);
		add(textFieldCate);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new FakeNews_Menu());
				frame.setVisible(true);
			}
		});
		btnVolver.setBounds(30, 499, 89, 23);
		add(btnVolver);
		
		textFechaRefutacion = new JTextField();
		textFechaRefutacion.setBounds(566, 75, 147, 20);
		add(textFechaRefutacion);
		textFechaRefutacion.setColumns(10);
		
		textFuentesRefutacion = new JTextField();
		textFuentesRefutacion.setBounds(566, 138, 147, 20);
		add(textFuentesRefutacion);
		textFuentesRefutacion.setColumns(10);
		
		
		chckbxOrganisOfi.setBounds(566, 200, 147, 23);
		add(chckbxOrganisOfi);
		
		textNombreRefutador = new JTextField();
		textNombreRefutador.setBounds(514, 336, 162, 20);
		add(textNombreRefutador);
		textNombreRefutador.setColumns(10);
		
		textApellidoRefutador = new JTextField();
		textApellidoRefutador.setBounds(514, 397, 162, 20);
		add(textApellidoRefutador);
		textApellidoRefutador.setColumns(10);
		
		textMedioRefutador = new JTextField();
		textMedioRefutador.setBounds(514, 463, 162, 20);
		add(textMedioRefutador);
		textMedioRefutador.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("REFUTADOR");
		lblNewLabel_1.setBounds(566, 283, 73, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("REFUTACION");
		lblNewLabel_2.setBounds(603, 11, 73, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FAKE NEW");
		lblNewLabel_3.setBounds(73, 11, 86, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Refutada:");
		lblNewLabel_4.setBounds(603, 41, 86, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fuentes:");
		lblNewLabel_5.setBounds(603, 113, 73, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre:");
		lblNewLabel_6.setBounds(419, 339, 46, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Apellido:");
		lblNewLabel_7.setBounds(419, 400, 46, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Medio:");
		lblNewLabel_8.setBounds(419, 466, 46, 14);
		add(lblNewLabel_8);
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
	
	
	public void cargarRefutacion(FakeNew r)
	{
		
		RefutadorDAO rdao = new RefutadorDAO();
		Refutacion refu = fa.buscarRefutacion(r);
		
		textFechaRefutacion.setText(refu.getFechaRefutada().toString());
		textFuentesRefutacion.setText(refu.getFuentes());
		if ( refu.isOrganismoOficial() == true)
		{
			 chckbxOrganisOfi.setEnabled(true);
		}
		else 
		{
			chckbxOrganisOfi.setEnabled(false);
		}
		
		
		Refutador refutadorx = refu.getRefutador();
		Refutador refutador = rdao.buscarRefutador(refutadorx);
		
		textNombreRefutador.setText(refutador.getNombre());
		textApellidoRefutador.setText(refutador.getApellido());
		textMedioRefutador.setText(refutador.getMedio());
		
		
	}
}
