package tano_construcciones;

public abstract class Servicio {
	protected int id; //Identifica el servicio
	protected String domicilio;
	protected double costoTotal; // costo total del servicio
	protected Especialista especialista; // Especialista asignado para realizar al trabajo
	protected boolean terminado;
	protected String tipo;
	
	// private double facturacionServicio; //Facturacion de cada servicio cuando se lo instancia
	static int ultimoCodigoAsignado = 0;
	static double facturacionTotal = 0; //Facturacion de TODOS los servicios
	
	public Servicio(String domicilio, Especialista especialista, String tipo) {
		this.domicilio = domicilio;
		this.especialista = especialista;
		this.tipo = tipo;
		this.terminado = false;
		
		ultimoCodigoAsignado++;
		this.id = ultimoCodigoAsignado;
	}
	
	//Metodos abstractos
	//public abstract double obtenerFacturacionTotal();
	//public abstract double cobrar();
	//public abstract Especialista cambiarEspecialista(); //Tipo Especialista?void?boolean?
	
	public double cobrar(double costoTotal) {
		this.costoTotal = costoTotal;
		facturacionTotal += costoTotal;
		
		this.terminado = true;
		
		return this.costoTotal;
	}
	
	protected void cambiarEspecialista(Especialista especialista) {
		this.especialista = especialista;
		return;
	}

	
	public int getId() {
		return this.id;
	}
	
}