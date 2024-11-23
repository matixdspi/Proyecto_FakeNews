package TpEstructuraDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TpEstructuraModelos.Refutador;



public class RefutadorDAO {

	//BUSQUEDA DE MEDIOS EN BASE AL NUMERO ASIGNADO Y VICEVERSA
	public String buscar_MedioOrigenNombre(int i)
	{
		if (i == 1)
		{
			return "Red Social";
		}
		else if (i == 2)
		{
			return "Medio Tradicional";
		}
		else if (i == 3)
		{
			return "Diario Digital";
		}
		else 
		{
			return null;
		}
	}
		public int buscar_MedioOrigenNum(String i)
		{
			if (i == "Red Social")
			{
				return 1;
			}
			else if (i == "Medio Tradicional")
			{
				return 2;
			}
			else if (i == "Diario Digital")
			{
				return 3;
			}
			else 
			{
				return 0;
			}
		
	}
		
		
	//CONEXION CON LA BASE DE DATOS
		public static Connection conectar() {
			String url = "jdbc:mysql://localhost:3306/tp_poo";
			String usr = "root";
			String pass = "mapadou2342";
			Connection conexion = null;
			try {
				conexion = DriverManager.getConnection(url, usr, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conexion;
		}

		public int traeridFakenews() {
			Connection conexion = conectar();

			try {

			} catch (Exception e) {
				// TODO: handle exception
			}
			return 0;

		}
	public ArrayList<Refutador> traerRefutador() {

		// Objetos de prueba
		ArrayList<Refutador> Refutadores = new ArrayList<Refutador>();
		Connection conexion = conectar();
		try {

			System.out.println("yeah");
			String sql = ("SELECT nombre, apellido, medio FROM refutador");

			PreparedStatement stmt = conexion.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int medio = rs.getInt("medio");
				Refutador u = new Refutador(nombre, apellido, buscar_MedioOrigenNombre(medio));
				Refutadores.add(u);
				System.out.println("Nombre: " + nombre + " Apellido" + apellido);
			}

		} catch (SQLException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException x) {
					// TODO: handle exception
					x.printStackTrace();
				}
			}
		}

		return Refutadores;
	}
	
	
	
	
}
