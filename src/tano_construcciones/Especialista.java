package tano_construcciones;

public class Especialista extends Persona{
	protected int nroEspecialista;
	private String especialidad;
	private int cantidadDeTrabajosRealizados;
	
	public Especialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		super(nombre, telefono);
		
		if(!validarDatos(nombre, telefono, especialidad))
			throw new RuntimeException("Los datos del especialista son invalidos");
		
		this.nroEspecialista = nroEspecialista;
		this.especialidad = especialidad;
		this.cantidadDeTrabajosRealizados = 0;
	}
	
	
	//---------------------
	//VALIDACIONES INTERNAS
	//---------------------
	private boolean validarDatos(String nombre, String telefono, String especialidad) {
		if(nombre=="" || telefono=="" || especialidad=="")
			return false;
		return true;
	}

	public int getNroEspecialista() {
		return nroEspecialista;
	}
	
	public String getEspecialidad() {
		return this.especialidad;
	}


	public int getCantidadDeTrabajosRealizados() {
		return this.cantidadDeTrabajosRealizados;
	}
}
