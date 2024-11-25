package TpEstructuraModelos;

import java.time.LocalDate;

public class Medio {
	
	private String ususario;
	private LocalDate fechaDivulgada;
	private boolean retractado;
	public String getUsusario() {
		return ususario;
	}
	public void setUsusario(String ususario) {
		this.ususario = ususario;
	}
	public LocalDate getFechaDivulgada() {
		return fechaDivulgada;
	}
	public void setFechaDivulgada(LocalDate fechaDivulgada) {
		this.fechaDivulgada = fechaDivulgada;
	}
	public boolean isRetractado() {
		return retractado;
	}
	public void setRetractado(boolean retractado) {
		this.retractado = retractado;
	}
	public Medio(String ususario, LocalDate fechaDivulgada, boolean retractado) {
		super();
		this.ususario = ususario;
		this.fechaDivulgada = fechaDivulgada;
		this.retractado = retractado;
	}
	
	

}
