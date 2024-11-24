package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraModelos.FakeNew;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class FakeNews_AltasyModificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTitulo;
	private JTextField textDescripcion;
	private JTextField textCreador;
	private JTextField textFechaApa;

	private String titulo;
	
	JComboBox comboBoxCategorias = new JComboBox(categoriasVector());
	JComboBox comboBoxMediosOrigen = new JComboBox(mediosVector());
	
	JButton btnGuardar = new JButton("GUARDAR");
	/**
	 * Create the panel.
	 */
	public FakeNews_AltasyModificacion() {
		CargarComponentes();

	}
	
	public FakeNews_AltasyModificacion(FakeNew fk) {
		CargarComponentes();
		Precargar_Objeto(fk);
		btnGuardar.setVisible(false);
		
		JButton btnModificar = new JButton("MODIFICAR");
		
		btnModificar.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
					
				//TITULO DE LA FAKE NEW A MODIFICAR
				titulo = fk.getTitulo();
				
				//OBTENCION DE LOS DATOS DE LA NUEVA  FAKE NEW
				String Titulo = textTitulo.getText();
				String Desc = textDescripcion.getText();
				String Creador = textCreador.getText();
				LocalDate fechaApa = LocalDate.parse(textFechaApa.getText());
				int MedioOrigen = comboBoxMediosOrigen.getSelectedIndex() + 1;
				int Categoria = comboBoxCategorias.getSelectedIndex() + 1;
				//IGUALACION A UN OBJETO DE FAKE NEW
				FakeNew fk = new FakeNew(Titulo, Desc, Creador, MedioOrigen, fechaApa , Categoria);
				
				FakeNew_DAO edao = new FakeNew_DAO();
				edao.actualizarFakeNews(fk, titulo);
				

				RefutacionRegistro menu = new RefutacionRegistro(fk);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(menu);

				frame.setVisible(true);
				
				
				
				}
				
				
				
				
				
		});
		
		
		btnModificar.setBounds(275, 463, 145, 31);
		add(btnModificar);
		btnModificar.setVisible(true);
		
		
		
			}


	
	
	
	public String[] mediosVector() {
		
		String[] medios = new String[3];
		FakeNew_DAO edao = new FakeNew_DAO();
		for (int i = 1; i <= medios.length; i++) {
			
			medios[i-1] = edao.buscar_MedioOrigenNombre(i);
			
		}
		return medios;
		}
	
	public String[] categoriasVector() {
		
		String[] categorias = new String[4];
		FakeNew_DAO edao = new FakeNew_DAO();
		for (int i = 1; i <= categorias.length; i++) {
			
			categorias[i-1] = edao.buscar_categorianNombre(i);
			
		}
		return categorias;
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
		
		
		//BOTON DE VOLVER
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				FakeNews_Menu menu = new FakeNews_Menu();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(menu);

				frame.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 486, 89, 23);
		add(btnVolver);
		
		JLabel lblNewLabel_2 = new JLabel("CREADOR");
		lblNewLabel_2.setBounds(102, 287, 73, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FECHA APARICION");
		lblNewLabel_3.setBounds(102, 386, 125, 14);
		add(lblNewLabel_3);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Titulo = textTitulo.getText();
				String Desc = textDescripcion.getText();
				String Creador = textCreador.getText();
				LocalDate fechaApa = LocalDate.parse(textFechaApa.getText());
				int MedioOrigen = comboBoxMediosOrigen.getSelectedIndex() + 1;
				int Categoria = comboBoxCategorias.getSelectedIndex() + 1;
				FakeNew fk = new FakeNew(Titulo, Desc, Creador, MedioOrigen, fechaApa , Categoria);
				
				FakeNew_DAO edao = new FakeNew_DAO();
				edao.FakeNews_Altas(fk);
				

				RefutacionRegistro menu = new RefutacionRegistro(fk);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(menu);

				frame.setVisible(true);
				
			}
		});
		btnGuardar.setBounds(275, 463, 145, 31);
		add(btnGuardar);
		
		
		comboBoxCategorias.setBounds(439, 178, 195, 40);
		add(comboBoxCategorias);
		
		
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
