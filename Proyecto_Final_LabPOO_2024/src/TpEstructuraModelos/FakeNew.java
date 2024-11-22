package TpEstructuraModelos;

import java.time.LocalDate;

public class FakeNew {
	
	private String titulo;
	private String descripcion;
	private String creador;
	private int medioOrigen;
	private LocalDate FechaApa;
	private int categoria;

	public FakeNew(String titulo, String descripcion, String creador, int medioOrigen, LocalDate fechaApa,
			int categoria) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.creador = creador;
		this.medioOrigen = medioOrigen;
		this.FechaApa = fechaApa;
		this.categoria = categoria;
		
	}
	public LocalDate getFechaApa() {
		return FechaApa;
	}
	public void setFechaApa(LocalDate fechaApa) {
		FechaApa = fechaApa;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCreador() {
		return creador;
	}
	public void setCreador(String creador) {
		this.creador = creador;
	}
	public int getMedioOrigen() {
		return medioOrigen;
	}
	public void setMedioOrigen(int medioOrigen) {
		this.medioOrigen = medioOrigen;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
}
