package TpEstructuraDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import TpEstructuraModelos.FakeNew;

public class FakeNew_DAO {
	
	
	
	
	public String buscar_categoria(int i)
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
	
	public String buscar_MedioOrigen(int i)
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
	
	//CONEXION CON LA BASE DE DATOS
	public static Connection conectar() {
		String url = "jdbc:mysql://localhost:3306/tp_poo_2024";
		String usr = "root";
		String pass = "admin";
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

	
	
	
	//METODO PARA LLENAR EN UN ARRAYLIST LAS FAKE NEWS QUE HAYA EN LA BASE DE DATOS
	public ArrayList<TpEstructuraModelos.FakeNew> traerFakenews() {
		// Objetos de prueba
		ArrayList<TpEstructuraModelos.FakeNew> FakeNewS = new ArrayList<FakeNew>();
		Connection conexion = conectar();
		try {

			System.out.println("Conecto traerfakenews");
			String sql = ("SELECT titulo, descripcion, creador, fechaApa, medioOrigen, categoria FROM fakenews");

			PreparedStatement stmt = conexion.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String creador = rs.getString("creador");
				LocalDate fechaApa = rs.getDate("fechaApa").toLocalDate();
				int medioOrigen = rs.getInt("medioOrigen");
				int categoria = rs.getInt("categoria");
				
				
				FakeNew u = new FakeNew(titulo, descripcion, creador, medioOrigen,fechaApa ,categoria);
				FakeNewS.add(u);
				System.out.println("Titulo: " + titulo + " descripcion" + descripcion + "creador" + categoria
						+ "Fecha Aparicion" + fechaApa + "MedioOrigen" + buscar_MedioOrigen(medioOrigen) + "Categoria" + buscar_categoria(categoria));
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

		return FakeNewS;
	}
	
	
	
	public void FakeNews_Altas(FakeNew fakeNew) {
		String sqlInsertarFK = "INSERT INTO fakenews (titulo, descripcion, creador, fechaApa, MedioOrigen, categoria) VALUES (?, ?, ?, ?, ?, ?);";
		Connection conexion = conectar();
		try {
			
			System.out.println("CONECTO ALTAS FAKE NEW");
			// QUERYS SQL
			PreparedStatement psInsertarFK = conexion.prepareStatement(sqlInsertarFK);
	

			// Insertar TABLA INTERMEDIA Fake News
			psInsertarFK.setString(1, fakeNew.getTitulo());
			psInsertarFK.setString(2, fakeNew.getDescripcion());
			psInsertarFK.setString(3, fakeNew.getCreador());
			psInsertarFK.setDate(4, java.sql.Date.valueOf(fakeNew.getFechaApa()));
			psInsertarFK.setInt(5, fakeNew.getMedioOrigen());
			psInsertarFK.setInt(6, fakeNew.getCategoria());

	

			int affectedRows = psInsertarFK.executeUpdate();
			System.out.println("INSERTO ALTAS FAKE NEW");
			
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

		
		
		public void bajas_FakeNews(FakeNew fakenews) {
			String sqlBorrarFakeNew = "DELETE FROM fakenews WHERE titulo = ?";
			

			Connection conexion = conectar();
			try {
				System.out.println("CONECTO BAJAS FAKE NEW");

				PreparedStatement stmt_BorrarFakeNew = conexion.prepareStatement(sqlBorrarFakeNew);
				
				// Eliminar Fake News
				stmt_BorrarFakeNew.setString(1, fakenews.getTitulo());
				
				int affectedRows = stmt_BorrarFakeNew.executeUpdate();

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
			
			
			
			
			
			public void actualizarFakeNews(FakeNew fakeNew, String fakenewsTitulo) {
				String sqlUpdateFakeNew = "UPDATE fakenews SET titulo = ?, descripcion = ?, creador = ?, fechaApa = ?, MedioOrigen = ?, categoria = ? WHERE titulo = ?";
				
				Connection conexion = conectar();
				try {
					
					System.out.println("CONECTO MODIFICACION FAKE NEW");
					PreparedStatement stmt_Update = conexion.prepareStatement(sqlUpdateFakeNew);
					
					// Actualizar Fake News
					stmt_Update.setString(1, fakeNew.getTitulo());
					stmt_Update.setString(2, fakeNew.getDescripcion());
					stmt_Update.setString(3, fakeNew.getCreador());
					stmt_Update.setDate(4, java.sql.Date.valueOf(fakeNew.getFechaApa()));
					stmt_Update.setInt(5, fakeNew.getMedioOrigen());
					stmt_Update.setInt(6, fakeNew.getCategoria());
					stmt_Update.setString(7, fakenewsTitulo);
					
					
					int tablas_afectadas = stmt_Update.executeUpdate();


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
