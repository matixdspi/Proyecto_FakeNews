package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import TpEstructuraDAOs.RefutadorDAO;
import TpEstructuraModelos.Refutador;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class RefutadorMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tablaRefutadores;
	
	/**
	 * Create the panel.
	 */
	public RefutadorMenu() {
		setLayout(null);
		
		// Creacion de panel y asignar las filas
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 28, 323, 213);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[] columnas = new Object[] { "Nombre", "Apellido", "Medio" };
		tablaRefutadores = new DefaultTableModel(columnas, 0);
		table.setModel(tablaRefutadores);
		
		// Llenar panel
		RefutadorDAO eDao = new RefutadorDAO();
		for (Refutador e : eDao.traerRefutador()) {
			tablaRefutadores.addRow(new Object[] { e.getNombre(), e.getApellido() , e.getMedio()});
		}
		
		// Actualizar panel - boton re cargar
		JButton btnReCargar = new JButton("Re cargar");
		btnReCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vacio la tabla.
				tablaRefutadores.setRowCount(0);
				// Traer datos para mostrar en tabla.
				RefutadorDAO eDAO = new RefutadorDAO();
				for (Refutador e1 : eDAO.traerRefutador()) {
					// Agregar una fila a la tabla por cada estudiante.
					tablaRefutadores.addRow(new Object[] { e1.getNombre(), e1.getApellido(), e1.getMedio() });
			}}
		});
		btnReCargar.setBounds(397, 42, 89, 23);
		add(btnReCargar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Refutador_AltasyModificacion());
				frame.setVisible(true);
			}
		});
		btnAgregar.setBounds(397, 102, 89, 23);
		add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaelegida = table.getSelectedRow();

				if (filaelegida != -1) {
					String Nombre = table.getValueAt(filaelegida, 0).toString();
					String Apellido = table.getValueAt(filaelegida, 1).toString();
					String MedioNombre = table.getValueAt(filaelegida, 2).toString();
					Refutador a = new Refutador(Nombre, Apellido, MedioNombre);
				

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Refutador_AltasyModificacion(a));
				frame.setVisible(true);
				}}
		});
		btnModificar.setBounds(397, 158, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaelegida = table.getSelectedRow();
				if (filaelegida != -1) {
					String Nombre = table.getValueAt(filaelegida, 0).toString();
					String Apellido = table.getValueAt(filaelegida, 1).toString();
					Refutador refutadorEliminar = new Refutador(Nombre, Apellido, null);
					System.out.println(Nombre + Apellido);
					RefutadorDAO eDao = new RefutadorDAO();
					eDao.bajas(refutadorEliminar);
				}
			}
		});
		btnEliminar.setBounds(397, 220, 89, 23);
		add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new FakeNews_Menu());
				frame.setVisible(true);
			}
			
			
		});
		btnVolver.setBounds(10, 276, 89, 23);
		add(btnVolver);
		
		
		
		
		
	}
}
