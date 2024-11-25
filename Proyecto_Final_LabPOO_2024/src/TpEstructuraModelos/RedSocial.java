package TpEstructuraModelos;

import java.time.LocalDate;

public class RedSocial extends Medio{

	
	public RedSocial(String ususario, LocalDate fechaDivulgada, boolean retractado, String plataforma, String usuario,
			int interaGeneradas) {
		super(ususario, fechaDivulgada, retractado);
		this.plataforma = plataforma;
		this.usuario = usuario;
		this.interaGeneradas = interaGeneradas;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getInteraGeneradas() {
		return interaGeneradas;
	}
	public void setInteraGeneradas(int interaGeneradas) {
		this.interaGeneradas = interaGeneradas;
	}
	private  String plataforma;
	private String usuario;
	private int interaGeneradas;
	
	
}
