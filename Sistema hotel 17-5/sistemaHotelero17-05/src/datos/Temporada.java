package datos;

import java.util.GregorianCalendar;

public class Temporada {			
	
	private int idTemporada;										
	private String nombre;
	private String descripcion;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;

	public Temporada(){} // CONSTRUCTOR HIBERNATE		

	public Temporada(String nombre, String descripcion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin) {			
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getIdTemporada() {
		return idTemporada;
	}

	protected void setIdTemporada(int idTemporada) { //Coincido. Protected 
		this.idTemporada = idTemporada;
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

	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	
} // end_class_Temporada