package TpEstructuraModelos;

public class Refutador {
	
	private String nombre;
	private String apellido;
	private String medio;
	public Refutador(String nombre, String apellido, String medio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.medio = medio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}

}
