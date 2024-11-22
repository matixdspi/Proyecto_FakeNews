package TpEstructuraModelos;

import java.time.LocalDate;

public class Refutacion {
	
	private Refutador refutador;
	private LocalDate fechaRefutada;
	private String fuentes;
	private boolean organismoOficial;
	
	
	
	
	public Refutacion(Refutador refutador, LocalDate fechaRefutada, String fuentes, boolean organismoOficial) {
		super();
		this.refutador = refutador;
		this.fechaRefutada = fechaRefutada;
		this.fuentes = fuentes;
		this.organismoOficial = organismoOficial;
	}




	public Refutador getRefutador() {
		return refutador;
	}




	public void setRefutador(Refutador refutador) {
		this.refutador = refutador;
	}




	public LocalDate getFechaRefutada() {
		return fechaRefutada;
	}




	public void setFechaRefutada(LocalDate fechaRefutada) {
		this.fechaRefutada = fechaRefutada;
	}




	public String getFuentes() {
		return fuentes;
	}




	public void setFuentes(String fuentes) {
		this.fuentes = fuentes;
	}




	public boolean isOrganismoOficial() {
		return organismoOficial;
	}




	public void setOrganismoOficial(boolean organismoOficial) {
		this.organismoOficial = organismoOficial;
	}
	

}
