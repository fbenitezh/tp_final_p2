package tano_construcciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Empresa {
	static String PINTURA = "Pintura";
	static String PINTURA_ALTURA = "PinturaEnAltura";
	static String ELECTRICIDAD = "Electricidad";
	static String GASISTA_INSTALACION = "GasistaInstalacion";
	static String GASISTA_REVISION = "GasistaRevision";
	private HashMap<Integer, Especialista> especialistas;
	private HashMap<Integer, Cliente> clientes;
	private HashMap<Integer, Servicio> servicios;
	private ArrayList<String> prestaciones;
	
	
	public Empresa() {
		ArrayList<String> prestaciones = new ArrayList<String>();
		prestaciones.add(Empresa.PINTURA);
		prestaciones.add(Empresa.PINTURA_ALTURA);
		prestaciones.add(Empresa.ELECTRICIDAD);
		prestaciones.add(Empresa.GASISTA_INSTALACION);
		prestaciones.add(Empresa.GASISTA_REVISION);
	}
	
	
	/**
	* Registra un nuevo cliente en el sistema dado su:
	* - dni,
	* - nombre y
	* - teléfono de contacto.
	*
	* Si el dni ya está en el sistema se debe generar una
	* excepción.
	*/
	public void registrarCliente(int dni, String nombre, String telefono) {
		Cliente cliente = new Cliente(nombre, telefono, dni);
		this.clientes.put(cliente.getDni(), cliente);
	}
	
	/**
	* Registra un nuevo especialista en el sistema dados su:
	* - nroEspecialista,
	* - nombre,
	* - teléfono y
	* - tipo De servicio en el que se especializa.
	*
	* Si el nroEspecialista ya está registrado en el sistema
	* se debe generar una excepción.
	*/
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		if(this.especialistas.get(nroEspecialista) != null) {
			throw new RuntimeException("El especialista ya existe");
		}
		Especialista especialista = new Especialista(nroEspecialista, nombre, telefono, especialidad);
		this.especialistas.put(especialista.getNroEspecialista(), especialista);
	}
	
	/**
	* Se registra la prestación de un servicio de tipo Electricidad en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por hora de trabajo del especialista
	* - cantidad de horas estimadas que llevará realizar el trabajo.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por hora o las horas de trabajo estimado son menores o
	* iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora, int horasTrabajadas) {
		Especialista especialista = this.validarPedidoDeServicio(dni, nroEspecialista, Empresa.ELECTRICIDAD);
		
		ServicioElectricidad serElectricidad = new ServicioElectricidad(direccion, especialista, direccion, horasTrabajadas, precioPorHora);
		this.servicios.put(serElectricidad.getId(), serElectricidad);
		
		return serElectricidad.getId();
	}
	
	/**
	* Se registra la prestación de un servicio de tipo Pintura en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados son menores o
	* iguales a 0, se debe generar una excepción.
	5 de 7
	*/
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados, double precioPorMetroCuadrado) {
		return 1;
	}
	
	/**
	* Se registra la prestación de un servicio de tipo PinturaEnAltura en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar
	* - nro de piso en el que se realizará el trabajo.
	* - costo del seguro
	* - costo del alquiler de los andamios.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados o el piso o el costo
	* del seguro o el costo del alquiler de los andamios son menores o iguales a 0,
	* se debe generar una excepción.
	*/
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados, double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {
		return 1;
	}
	
	/**
	* Se registra la prestación de un servicio de tipo GasistaInstalacion en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a instalar
	* - precio por la instalación de un artefacto.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a instalar son
	* menores o iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		return 1;
	}
	
	/**
	* Se registra la prestación de un servicio de tipo GasistaRevison en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a revisar
	* - precio por la revisión de un artefacto.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	6 de 7
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a revisar son
	* menores o iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		return 1;
	}
	
	/**
	* Se registra que el servicio solicitado ya fué concluido. Para esto se debe
	* ingresar el costo de los materiales utilizados para poder realizar el
	* trabajo.
	*
	* Se devuelve el precio que se debe facturar al cliente.
	* Este precio se obtiene sumando el costo de los materiales con el costo del
	* servicio realizado. Cada tipo de servicio tiene su forma de calcular el
	* costo del trabajo.
	*
	* Si el código de servicio no está en el sistema o el mismo ya fué finalizado,
	* se debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	*/
	public double finalizarServicio(int codServicio, double costoMateriales) {
		return 1;
	}
	
	/**
	* Devuelve un diccionario cuya clave es el tipo de servicio y el valor es la
	* cantidad de servicios realizados de ese tipo.
	* Si un tipo de servicio no tuvo ninguna demanda, el valor de esa entrada debe
	* ser 0.
	*/
	public HashMap<String,Integer> cantidadDeServiciosRealizadosPorTipo(){
		return new HashMap<String, Integer>();
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* son del tipo pasado por parámetro.
	* Si el tipo de servicio es invalido, debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	*/
	public double facturacionTotalPorTipo(String tipoServicio) {
		return 1;
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* realizó la empresa.
	*/
	public double facturacionTotal() {
		return 1;
	}
	
	/**
	* Debe cambiar el especialista responsable del servicio.
	* Si código de Servicio o el nroEspecialista no están registrados en el sistema
	* se debe generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	*
	*
	* Se debe realizar esta operación en O(1).
	*/
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		
	}
	
	/**
	* Devuelve un String con forma de listado donde cada renglón representa un
	* servicio realizado.
	* Cada renglón debe respetar el siguiente formato:
	* " + [ codServicio - GasistaInstalacion ] Dirección"
	* por ejemplo:
	* " + [ 1492 - GasistaInstalacion ] uan María Gutiérrez 1150"
	* Si el nroEspecialista no está registrado en el sistema, se debe generar una excepción.
	* Si el especialista no ha realizado ningún servicio hasta el momento, se debe devolver un string vacio
	*/
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		return "";
	}
	
	
	/**
	 * Realiza las validaciones correspondientes para crear un servicio
	 * @param dni
	 * @param nroEspecialista
	 * @param especialidad
	 * @return
	 */
	private Especialista validarPedidoDeServicio(int dni, int nroEspecialista, String especialidad) {
		if(this.clientes.get(dni) == null) {
			throw new RuntimeException("el cliente no existe");
		}
		Especialista especialista = this.especialistas.get(nroEspecialista);
		if(especialista == null) {
			throw new RuntimeException("El especialista no existe");
		}
		if(especialista.getEspecialidad() != especialidad) {
			throw new RuntimeException("El especialista no puede realizar este servicio");
		}
		
		return especialista;
	}
	
}
