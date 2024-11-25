package TpEstructuraModelos;

import java.time.LocalDate;

public class MedioTradiEscrito extends Medio{

	
	private String nombreDiario;
	private String nombreNota;
	private int cantVisualizaciones;
	public String getNombreDiario() {
		return nombreDiario;
	}
	public void setNombreDiario(String nombreDiario) {
		this.nombreDiario = nombreDiario;
	}
	public String getNombreNota() {
		return nombreNota;
	}
	public void setNombreNota(String nombreNota) {
		this.nombreNota = nombreNota;
	}
	public int getCantVisualizaciones() {
		return cantVisualizaciones;
	}
	public void setCantVisualizaciones(int cantVisualizaciones) {
		this.cantVisualizaciones = cantVisualizaciones;
	}
	public MedioTradiEscrito(String ususario, LocalDate fechaDivulgada, boolean retractado, String nombreDiario,
			String nombreNota, int cantVisualizaciones) {
		super(ususario, fechaDivulgada, retractado);
		this.nombreDiario = nombreDiario;
		this.nombreNota = nombreNota;
		this.cantVisualizaciones = cantVisualizaciones;
	}
	
}
