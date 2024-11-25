package TpEstructuraDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import TpEstructuraModelos.FakeNew;
import TpEstructuraModelos.Refutacion;
import TpEstructuraModelos.Refutador;

public class RefutacionDAO {
	public static Connection conectar()
	{
		String url = "jdbc:mysql://localhost:3306/tp_poo";
		String usr =	"root";
		String pass =	"admin";
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void refutacionAltas(Refutacion r, FakeNew fk)
	{
		String sqlInsertarRefutacion = "INSERT INTO Refutacion(fechaRetr, fuentesOrigen, organismoOfi, fakenew, refutador) VALUES (?, ?, ?, ?, ?);";
		Connection conexion = conectar();
		try {
			
			System.out.println("CONECTO ALTAS FAKE NEW");
			// QUERYS SQL
			PreparedStatement psInsertarRN = conexion.prepareStatement(sqlInsertarRefutacion);
	

			// Insertar TABLA INTERMEDIA Fake News
			psInsertarRN.setDate(1, java.sql.Date.valueOf(r.getFechaRefutada()));
			psInsertarRN.setString(2, r.getFuentes());
			psInsertarRN.setBoolean(3, r.isOrganismoOficial());
			psInsertarRN.setString(4, fk.getTitulo());
			psInsertarRN.setString(5, r.getRefutador().getNombre());
			

	

			int affectedRows = psInsertarRN.executeUpdate();
			System.out.println("INSERTO ALTAS REFUTACIOn");
			
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
	
	
	
	public void refutacionModificacion(Refutacion r, FakeNew fk, String titulofk)
	{
		String sqlModificarRefutacion = "UPDATE  Refutacion SET fechaRetr = ?, fuentesOrigen = ?, organismoOfi = ? , fakenew = ? , refutador = ? WHERE fakenew = ?;";
		Connection conexion = conectar();
		try {
			
			System.out.println("CONECTO ALTAS FAKE NEW");
			// QUERYS SQL
			PreparedStatement psInsertarRN = conexion.prepareStatement(sqlModificarRefutacion);
	

			// Insertar TABLA INTERMEDIA Fake News
			psInsertarRN.setDate(1, java.sql.Date.valueOf(r.getFechaRefutada()));
			psInsertarRN.setString(2, r.getFuentes());
			psInsertarRN.setBoolean(3, r.isOrganismoOficial());
			psInsertarRN.setString(4, fk.getTitulo());
			psInsertarRN.setString(5, titulofk);
			

	

			int affectedRows = psInsertarRN.executeUpdate();
			System.out.println("INSERTO MODIFICACION REFUTACIOn");
			
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
	
	
	
	
	public Refutacion buscarRefutacion(FakeNew fk)
	{
		
		Refutacion r = new Refutacion(null, null, null, false);

		Connection conexion = conectar();
		try {
			
			System.out.println("CONECTO ALTAS FAKE NEW");
			String sqlSeleccionarRefutacion = "SELECT fechaRetr,fuentesOrigen,organismoOfi,refutador FROM Refutacion WHERE fakenew=?;";

			PreparedStatement stmt = conexion.prepareStatement(sqlSeleccionarRefutacion);
			stmt.setString(1, fk.getTitulo());
			ResultSet rs = stmt.executeQuery();

	

			if (rs.next()) {
			LocalDate fechaApa = rs.getDate("fechaRetr").toLocalDate();
			String fuente = rs.getString("fuentesOrigen");
			boolean organismo = rs.getBoolean("organismoOfi");
			System.out.println("metodo busccar refutacion bool organismo: " + organismo);
			String refutador = rs.getString("refutador");
			Refutador refu = new Refutador(refutador, null, null);
			
				r.setRefutador(refu);
					r.setFechaRefutada(fechaApa);
					r.setFuentes(fuente); 
					r.setOrganismoOficial(organismo);
	
			System.out.println("TRAJO REFUTACIOn");
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
		
		
		
		return r;
	}
}
