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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class FakeNews_Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFiltrar;
	private JTable table;
	private DefaultTableModel tablaFakeNews;

	/**
	 * Create the panel.
	 */
	public FakeNews_Menu() {
		setLayout(null);
		
		
		
		
		JScrollPane TablaFakeNews = new JScrollPane();
		TablaFakeNews.setBounds(39, 102, 660, 327);
		add(TablaFakeNews);
		
		table = new JTable();
		TablaFakeNews.setViewportView(table);
		Object[] columnas = new Object[] { "Titulo", "Fecha Aparicion","Creador", "Medio", "Categoria" };
		tablaFakeNews = new DefaultTableModel(columnas, 0);
		table.setModel(tablaFakeNews);
		
		textFiltrar = new JTextField();
		textFiltrar.setBounds(73, 49, 398, 32);
		add(textFiltrar);
		textFiltrar.setColumns(10);
		
		
		//FILTRADO DE FAKE NEWS
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FakeNew_DAO edao = new FakeNew_DAO();
				FakeNew fk = new FakeNew(textFiltrar.getText().toString(), null, null, 0, null, 0);
				//LIMPIAR TABLA
				tablaFakeNews.setRowCount(0);
				//TRAER FAKE NEWS FILTRADAS
				ArrayList<FakeNew> FakesFiltradas = edao.buscarPorTitulo(fk);
			
				for (FakeNew x : FakesFiltradas) 
				{
					tablaFakeNews.addRow(new Object[] {
							
							x.getTitulo(),
							x.getFechaApa(),
							x.getCreador(),
							edao.buscar_MedioOrigenNombre(x.getMedioOrigen()),
							edao.buscar_categorianNombre(x.getCategoria())		
							
					});
				}
			
			}
		});
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
		btnAltas.setBounds(512, 474, 89, 23);
		add(btnAltas);
		
		
		//BOTON DE MODIFICACION
		JButton btnModificacion = new JButton("MODIFICAR");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int filaelegida = table.getSelectedRow();
			FakeNew_DAO edao = new FakeNew_DAO();
				if(filaelegida != -1)
				{
				String t = table.getValueAt(filaelegida, 0).toString();
				LocalDate fechaApa = LocalDate.parse(table.getValueAt(filaelegida,1).toString());
				String c = table.getValueAt(filaelegida,2).toString();
				int medio = edao.buscar_categoriaNum(table.getValueAt(filaelegida,3).toString());
				int cate = edao.buscar_MedioOrigenNum(table.getValueAt(filaelegida,4).toString());
				FakeNew fk = new FakeNew(t, null , c, medio, fechaApa, cate);
				
				
				
				
				
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new FakeNews_AltasyModificacion(fk));

				frame.setVisible(true);
				}
			}
		});
		btnModificacion.setBounds(665, 474, 102, 23);
		add(btnModificacion);
		
		
	//BOTON DE BAJAS
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaelegida = table.getSelectedRow();				
				FakeNew_DAO edao = new FakeNew_DAO();
				
				if (filaelegida != -1)
				{
					FakeNew fk = new FakeNew(table.getValueAt(filaelegida, 0).toString(), null, null, 0, null, 0);
					System.out.println("TITULO ELEGIDO PARA BAJAS: " + fk.getTitulo());
					edao.bajas_FakeNews(fk);
				}
				
			}
		});
		btnBorrar.setBounds(729, 229, 89, 23);
		add(btnBorrar);
		
		JButton btnVistaFakeNews = new JButton("VER");
		btnVistaFakeNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				
			}
		});
		btnVistaFakeNews.setBounds(729, 124, 89, 23);
		add(btnVistaFakeNews);
		
		
		FakeNew_DAO eDao = new FakeNew_DAO();
		for (FakeNew x: eDao.traerFakenews()) {
			
			tablaFakeNews.addRow(new Object[] { x.getTitulo(), x.getFechaApa(),x.getCreador(), eDao.buscar_MedioOrigenNombre(x.getMedioOrigen()), eDao.buscar_categorianNombre(x.getCategoria()),  });
		}

	}
}
