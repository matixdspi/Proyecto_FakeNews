package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


import TpEstructuraDAOs.FakeNew_DAO;
import TpEstructuraModelos.FakeNew;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class FakeNews_Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tablaFakeNews;

	/**
	 * Create the panel.
	 */
	public FakeNews_Menu() {
		setLayout(null);
		
		
		
		
		JScrollPane TablaFakeNews = new JScrollPane();
		TablaFakeNews.setBounds(39, 102, 547, 285);
		add(TablaFakeNews);
		
		table = new JTable();
		TablaFakeNews.setViewportView(table);
		Object[] columnas = new Object[] { "Titulo", "Fecha Aparicion", "Medio", "Categoria" };
		tablaFakeNews = new DefaultTableModel(columnas, 0);
		table.setModel(tablaFakeNews);
		
		textField = new JTextField();
		textField.setBounds(73, 49, 398, 32);
		add(textField);
		textField.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(497, 54, 89, 23);
		add(btnFiltrar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MenuPrincipal menu = new MenuPrincipal();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(menu);

				frame.setVisible(true);
				
				
			}
		});
		btnVolver.setBounds(10, 474, 89, 23);
		add(btnVolver);
		
		
		//BOTON ALTAS
		JButton btnAltas = new JButton("CREAR");
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FakeNews_AltasyModificacion atr = new FakeNews_AltasyModificacion();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(atr);

				frame.setVisible(true);
				
				
			}
		});
		btnAltas.setBounds(333, 474, 89, 23);
		add(btnAltas);
		
		
		//BOTON DE MODIFICACION
		JButton btnModificacion = new JButton("MODIFICAR");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FakeNews_AltasyModificacion a = new FakeNews_AltasyModificacion();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(a);

				frame.setVisible(true);
			
			}
		});
		btnModificacion.setBounds(451, 474, 102, 23);
		add(btnModificacion);
		
		
	//BOTON DE BAJAS
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnBorrar.setBounds(594, 217, 89, 23);
		add(btnBorrar);
		
		JButton btnVistaFakeNews = new JButton("VER");
		btnVistaFakeNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				
			}
		});
		btnVistaFakeNews.setBounds(596, 107, 89, 23);
		add(btnVistaFakeNews);
		
		
		FakeNew_DAO eDao = new FakeNew_DAO();
		for (FakeNew x: eDao.traerFakenews()) {
			
			tablaFakeNews.addRow(new Object[] { x.getTitulo(), x.getFechaApa(), eDao.buscar_MedioOrigen(x.getMedioOrigen()), eDao.buscar_categoria(x.getCategoria()) });
		}

	}
}
