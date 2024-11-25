package TpEstructuraApp;

import javax.swing.JFrame;

import TpEstructuraVistas.FakeNews_AltasyModificacion;
import TpEstructuraVistas.MenuPrincipal;
import TpEstructuraVistas.RefutacionRegistro;
import TpEstructuraVistas.RefutadorMenu;
import TpEstructuraVistas.Refutador_AltasyModificacion;



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
