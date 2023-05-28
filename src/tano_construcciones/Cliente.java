package tano_construcciones;

public class Cliente extends Persona{
	private int dni;
	
	public Cliente(String nombre, String telefono, int dni) {
		super(nombre, telefono);
		this.dni = dni;
	}

	public int getDni() {
		return this.dni;
	}
}
