package datos;

import java.util.Set;

public class TipoHabitacion {

	
	private long idTipoHabitacion;
	private String nombre;
	private String descripcion;
	private int capacidad;
	private String servicios;
	
	//Relaciones
	private Set<TipoHabitacionXTemporada> tipoHabitacionXTemporadas;
	private Set<Habitacion> habitaciones;
	
	//Constructores
	public TipoHabitacion(String nombre, String descripcion, int capacidad, String servicios) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.servicios = servicios;
	}
	
	public TipoHabitacion(){}
	
	//Gets y sets

	public long getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	protected void setIdTipoHabitacion(long idTipoHabitacion) {
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

	public Set<TipoHabitacionXTemporada> getTipoHabitacionXTemporadas() {
		return tipoHabitacionXTemporadas;
	}

	public void setTipoHabitacionXTemporadas(Set<TipoHabitacionXTemporada> tipoHabitacionXTemporadas) {
		this.tipoHabitacionXTemporadas = tipoHabitacionXTemporadas;
	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	
	
}
