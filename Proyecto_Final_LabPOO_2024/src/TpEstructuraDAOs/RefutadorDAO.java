package TpEstructuraDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import TpEstructuraModelos.Refutador;
	


public class RefutadorDAO {
	
	public String buscar_categorianNombre(int i)
	{
		if (i == 1)
		{
			return "Contenido Engañoso";
		}
		else if (i == 2)
		{
			return "Contexto Falso";
		}
		else if (i == 3)
		{
			return "Contenido Manipulado";
		}
		else if (i == 4)
		{
			return "Desinformacion";
		}
		else 
		{
			return null;
		}
		
	}
	public int  buscar_categoriaNum(String i)
	{
		if (i == "Contenido Engañoso")
		{
			return 1;
		}
		else if (i == "Conetexto Falso")
		{
			return 2;
		}
		else if (i == "Contenido Manipulado")
		{
			return 3;
		}
		else if (i == "Desinformacion")
		{
			return 4;
		}
		else 
		{
			return 0;
		}
		
	}

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
	
	public static Connection conectar()
	{
		String url = "jdbc:mysql://localhost:3306/tp_poo";
		String usr =	"root";
		String pass =	"mapadou2342";
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public ArrayList<Refutador> traerRefutador() {
		// Objetos de prueba
		ArrayList<Refutador> Refutadores = new ArrayList<Refutador>();
		//FakeNew_DAO fa = null;
		Connection conexion  = conectar();
		try {
			System.out.println("Conexion correcta - TRAER REFUTADORES");
			String sql = ("SELECT nombre, apellido, medio FROM refutador");
	
			PreparedStatement stmt = conexion.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next())
			{	
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int numeroMedio = rs.getInt("medio");
				String nombreMedio = buscar_MedioOrigenNombre(numeroMedio);
				Refutador refutadorTraido = new Refutador(nombre, apellido, nombreMedio);
				Refutadores.add(refutadorTraido);
				System.out.println("Nombre: " + nombre  + " Apellido: " + apellido + " Nombre del Medio: " + nombreMedio);
			}
		} 
		catch (SQLException x) 
		{
			// TODO Auto-generated catch block
			x.printStackTrace();
		}	
		finally 
		{
			if (conexion != null)
			{
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
	
	public void altas(Refutador e, int numeroMedio){
		Connection conexion = conectar();
		FakeNew_DAO fa = null;
		try{				
			System.out.println("Conexion correcta - ALTAS REFUTADOR");
			String sql = ("INSERT INTO refutador (nombre, apellido, medio) VALUES(? , ?, ?);");
		
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, e.getNombre());
			stmt.setString(2, e.getApellido());
			stmt.setInt(3, numeroMedio);
			
			stmt.executeUpdate();
			System.out.println("SUBIO");
			}
		catch (SQLException x){
			// TODO Auto-generated catch block
			x.printStackTrace();
			}
		finally {
				if (conexion != null)
				{
					try{
						conexion.close();
					} catch (SQLException x) {
						// TODO: handle exception
						x.printStackTrace();
						}
					}
				}
	}
	
	public void modificacion(String Apellido, Refutador e, int numeroMedio) {
		Connection conexion = conectar();
		String nombreMedio=buscar_MedioOrigenNombre(numeroMedio);;
		try {
			System.out.println("Conexion correcta - MODIFICACION REFUTADOR");
			String sql = ("UPDATE refutador SET nombre =?, apellido =?, medio=? WHERE apellido =?;");

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, e.getNombre());
			stmt.setString(2, e.getApellido());
			stmt.setInt(3, numeroMedio);
			stmt.setString(4, Apellido);

			System.out.println("NOMBRE: " + e.getNombre() + " APELLIDO: " + e.getApellido() + " MEDIO: " + nombreMedio + "ANTERIOR APELLIDO: " + Apellido);
			stmt.executeUpdate();
			System.out.println("MODIFICO");

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
	}
	
	public void bajas(Refutador e) {
		Connection conexion = conectar();
		try {
			System.out.println("Conexion correcta - BAJAS REFUTADOR");
			String sql = ("DELETE FROM refutador WHERE nombre =? AND apellido =? ");

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, e.getNombre());
			stmt.setString(2, e.getApellido());

			stmt.executeUpdate();
			System.out.println("ELIMINO");

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

	}
}
	
	

