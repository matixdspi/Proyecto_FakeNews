package TpEstructuraVistas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MenuPrincipal() {
		setLayout(null);
		
		JButton btnFakeNews = new JButton("Fake News");
		btnFakeNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				FakeNews_Menu pan = new FakeNews_Menu();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(pan);

				frame.setVisible(true);
			}
		});
		btnFakeNews.setBounds(43, 236, 89, 23);
		add(btnFakeNews);
		
		JButton btnAsignarMedios = new JButton("Asignar Medios");
		btnAsignarMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				FakeNews_Menu pan = new FakeNews_Menu();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(pan);

				frame.setVisible(true);
			
			
			}
		});
		btnAsignarMedios.setBounds(175, 236, 105, 23);
		add(btnAsignarMedios);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				FakeNews_Menu pan = new FakeNews_Menu();
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(pan);

				frame.setVisible(true);
			}
		});
		btnReportes.setBounds(328, 236, 89, 23);
		add(btnReportes);
		
		JLabel lblNewLabel = new JLabel("FAKE NEWS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 48, 193, 51);
		add(lblNewLabel);

	}
}
