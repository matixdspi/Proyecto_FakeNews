package TpEstructuraModelos;

import java.time.LocalDate;

public class MedioTradiVisual extends Medio{
	
	private String nombrePrograma;
	private int minutosDedicados;
	private int rating;
	public String getNombrePrograma() {
		return nombrePrograma;
	}
	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}
	public int getMinutosDedicados() {
		return minutosDedicados;
	}
	public void setMinutosDedicados(int minutosDedicados) {
		this.minutosDedicados = minutosDedicados;
	}
	public int getRating() {
		return rating;
	}
	public MedioTradiVisual(String ususario, LocalDate fechaDivulgada, boolean retractado, String nombrePrograma,
			int minutosDedicados, int rating) {
		super(ususario, fechaDivulgada, retractado);
		this.nombrePrograma = nombrePrograma;
		this.minutosDedicados = minutosDedicados;
		this.rating = rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

}
