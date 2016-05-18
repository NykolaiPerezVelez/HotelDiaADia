package datos;

import java.util.ArrayList;
import java.util.List;

public class TipoHabitacion {

	private int idTipoHabitacion;							
	private String nombre;
	private String descripcion;					
	private int capacidad;
	private List<Habitacion> habitaciones;	
	//Lista de habitaciones que tienen ese Tipo. Lo veo como una relacion bidireccional parecida a Prestamo y Cliente. Me importa la lista de prestamos (habitaciones) de un cliente (tipo de habitacion)
	// pero a su vez que cuando muestro un prestamo (habitacion) me devuelva el cliente (tipo de habitacion). 					 						
	private String servicios; 
	
	public TipoHabitacion(String nombre, String descripcion, int capacidad, String servicios) {			
		super();
		this.nombre = nombre;	
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.servicios = servicios;
		this.habitaciones = new ArrayList<Habitacion>();	
	}
	
	
	public List<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	
	public void setHabitaciones(List<Habitacion> habitaciones){
		this.habitaciones = habitaciones; 
	}	
	
	//Para agregar habitaciones a este tipo de habitacion. 				
	public void agregarHabitacion() {											
		habitaciones.add(new Habitacion(this));					
	}								

	public int getIdTipoHabitacion() {
		return idTipoHabitacion;	
	}

	protected void setIdTipoHabitacion(int idTipoHabitacion) { //Coincido. Protected. 												
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	
	public String toString(){
		return ("idTipoHabitacion: "+idTipoHabitacion+"|| Nombre: "+nombre+" || Descripcion: "+descripcion+" || capacidad: "+capacidad);
	}
	
} // end_class_TipoHabitacion