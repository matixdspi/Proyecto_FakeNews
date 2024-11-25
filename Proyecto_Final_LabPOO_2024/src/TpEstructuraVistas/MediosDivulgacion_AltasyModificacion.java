package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraModelos.FakeNew;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MediosDivulgacion_AltasyModificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JTextField textFecha;
	private JTextField textField_PrimerDato;
	private JTextField textField_SegundoDato;
	private JTextField textField_TercerDato;
	
	JComboBox comboBoxFakeNewsTitulo = new JComboBox(vectorFakeNewsTitulos());

	/**
	 * Create the panel.
	 */
	
	public String[] vectorFakeNewsTitulos()
	{
		FakeNew_DAO edao = new FakeNew_DAO();
		ArrayList<FakeNew> fk = edao.traerFakenews();
		String[] fkTitulos = new String [fk.size()];
		
		for (FakeNew x : fk) {
			fkTitulos[fk.indexOf(x)] = x.getTitulo();
		}
		return fkTitulos;
	
	}
	
	//ALTAS
	public MediosDivulgacion_AltasyModificacion() {
	
		agregarComponentes();
		
	}
	
	
	
	public void precargarObjeto()
	{
		
	}
	
	public void agregarComponentes()
	{
		
	setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(33, 50, 170, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(33, 114, 170, 20);
		add(textFecha);
		textFecha.setColumns(10);
		
		JCheckBox chckbxRetractado = new JCheckBox("SE RETRACTO?");
		chckbxRetractado.setBounds(33, 196, 122, 23);
		add(chckbxRetractado);
		
		
		comboBoxFakeNewsTitulo.setBounds(33, 271, 170, 28);
		add(comboBoxFakeNewsTitulo);
		
		textField_PrimerDato = new JTextField();
		textField_PrimerDato.setBounds(395, 110, 170, 28);
		add(textField_PrimerDato);
		textField_PrimerDato.setColumns(10);
		
		textField_SegundoDato = new JTextField();
		textField_SegundoDato.setBounds(395, 197, 170, 22);
		add(textField_SegundoDato);
		textField_SegundoDato.setColumns(10);
		
		textField_TercerDato = new JTextField();
		textField_TercerDato.setBounds(395, 275, 170, 20);
		add(textField_TercerDato);
		textField_TercerDato.setColumns(10);
		
		
		//BOTON DE ALTAS
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnGuardar.setBounds(267, 378, 106, 28);
		add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(267, 378, 106, 28);
		add(btnModificar);

	}
}
