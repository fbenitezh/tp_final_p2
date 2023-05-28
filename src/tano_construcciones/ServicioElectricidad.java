package tano_construcciones;

public class ServicioElectricidad extends Servicio{
	private int horas;
	private double valor_hora;
	static double facturacionDelServicio = 0;
	
	public ServicioElectricidad(String domicilio, Especialista especialista, String tipo, int horas, double valorHora) {
		super(domicilio, especialista, tipo);
		
		this.horas = horas;
		this.valor_hora = valorHora;
	}
	
	@Override
	public double cobrar(double costoMateriales) {
		// calculo el total
		double total = (valor_hora * horas) + costoMateriales;
		
		// modifico el total en la variable de instancia
		super.cobrar(total);
		
		// incremento el acumulador para el total de este servicio
		facturacionDelServicio += total;
		
		return this.costoTotal;
	}
}
