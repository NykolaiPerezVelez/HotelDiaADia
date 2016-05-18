package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Temporada {
	
	
	private long idTemporada;
	private String nombre;
	private GregorianCalendar fechaInicia;
	private GregorianCalendar fechaTermina;
	
	//Relaciones
	private Set<TipoHabitacionXTemporada> tipoHabitacionXTemporadas;

	
	//Constructores
	
	public Temporada(String nombre, GregorianCalendar fechaInicia, GregorianCalendar fechaTermina) {
		this.nombre = nombre;
		this.fechaInicia = fechaInicia;
		this.fechaTermina = fechaTermina;
		
	}
	
	public Temporada(){}

	
	//Gets y sets
	public long getIdTemporada() {
		return idTemporada;
	}

	protected void setIdTemporada(long idTemporada) {
		this.idTemporada = idTemporada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GregorianCalendar getFechaInicia() {
		return fechaInicia;
	}

	public void setFechaInicia(GregorianCalendar fechaInicia) {
		this.fechaInicia = fechaInicia;
	}

	public GregorianCalendar getFechaTermina() {
		return fechaTermina;
	}

	public void setFechaTermina(GregorianCalendar fechaTermina) {
		this.fechaTermina = fechaTermina;
	}

	public Set<TipoHabitacionXTemporada> getTipoHabitacionXTemporadas() {
		return tipoHabitacionXTemporadas;
	}

	public void setTipoHabitacionXTemporadas(Set<TipoHabitacionXTemporada> tipoHabitacionXTemporadas) {
		this.tipoHabitacionXTemporadas = tipoHabitacionXTemporadas;
	}
	
	
	
	
	

}
