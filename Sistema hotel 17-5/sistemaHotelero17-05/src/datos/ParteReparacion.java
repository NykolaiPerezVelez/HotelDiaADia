package datos;

import java.util.GregorianCalendar;

public class ParteReparacion {
	
	private int idParteReparacion;		
	private GregorianCalendar fechaParte; //Yo le pondria "fechaCreacionParte" o solo "fechaCreacion". Es solo un comentario. 
	private GregorianCalendar fechaResolucion;
	private Empleado empleado;			
	private Habitacion habitacion; 
	private String desperfecto;			
	private String comentarios;						
	
	public ParteReparacion(){} // CONSTRUCTOR HIBERNATE

	public ParteReparacion(int idParteReparacion, GregorianCalendar fechaParte, GregorianCalendar fechaResolucion,
			Empleado empleado, Habitacion habitacion, String desperfecto, String comentarios) { //Lo mismo comentado antes en los constructores:
				// - fechaResolucion -> Depende como dije en otras clases. Si antes de la implementacion de un sistema ya existian partes de reparacion y se quieren guardar, es valido.
		super();																								
		this.idParteReparacion = idParteReparacion;
		this.fechaParte = fechaParte;
		this.fechaResolucion = fechaResolucion;
		this.empleado = empleado;
		this.habitacion = habitacion;
		this.desperfecto = desperfecto;
		this.comentarios = comentarios;
	}
	
	//Creo un constructor sobrecargado abajo sin fechaResolucion									
	public ParteReparacion(int idParteReparacion, GregorianCalendar fechaParte,
			Empleado empleado, Habitacion habitacion, String desperfecto, String comentarios) {
		super();																					
		this.idParteReparacion = idParteReparacion;
		this.fechaParte = fechaParte;
		this.empleado = empleado;
		this.habitacion = habitacion;
		this.desperfecto = desperfecto;
		this.comentarios = comentarios;				
	}				

	public int getIdParteReparacion() {
		return idParteReparacion;
	}

	protected void setIdParteReparacion(int idParteReparacion) { //Coincido. Protected. 
		this.idParteReparacion = idParteReparacion;
	}

	public GregorianCalendar getFechaParte() {
		return fechaParte;
	}

	public void setFechaParte(GregorianCalendar fechaParte) {
		this.fechaParte = fechaParte;
	}

	public GregorianCalendar getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(GregorianCalendar fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public String getDesperfecto() {
		return desperfecto;
	}

	public void setDesperfecto(String desperfecto) {
		this.desperfecto = desperfecto;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

} // end_class_ParteReparacion