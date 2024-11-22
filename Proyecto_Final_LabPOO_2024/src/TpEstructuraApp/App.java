package TpEstructuraApp;

import javax.swing.JFrame;

import TpEstructuraVistas.MenuPrincipal;



public class App {

	public static void main(String[] args) {
		JFrame marco = new JFrame();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setBounds(0, 0, 1280, 720);
		MenuPrincipal inicio = new MenuPrincipal();
		marco.setContentPane(inicio);
		marco.validate();
		
}
}
