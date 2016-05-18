package datos;

import java.util.GregorianCalendar;

public class ParteReparacion {
	
	private long idParteReparacion;
	private String desperfecto;
	private GregorianCalendar fechaOrigen;
	private GregorianCalendar fechaResolucion;
	private String comentario;
	
	//Relaciones
	private Habitacion habitacion;
	private Login login;
	
	//Constructores
	public ParteReparacion(String desperfecto, GregorianCalendar fechaOrigen, GregorianCalendar fechaResolucion,
			String comentario, Habitacion habitacion, Login login) {
		super();
		this.desperfecto = desperfecto;
		this.fechaOrigen = fechaOrigen;
		this.fechaResolucion = fechaResolucion;
		this.comentario = comentario;
		this.habitacion = habitacion;
		this.login = login;
	}
	
	public ParteReparacion(){}

	
	//Get y ets
	public long getIdParteReparacion() {
		return idParteReparacion;
	}

	protected void setIdParteReparacion(long idParteReparacion) {
		this.idParteReparacion = idParteReparacion;
	}

	public String getDesperfecto() {
		return desperfecto;
	}

	public void setDesperfecto(String desperfecto) {
		this.desperfecto = desperfecto;
	}

	public GregorianCalendar getFechaOrigen() {
		return fechaOrigen;
	}

	public void setFechaOrigen(GregorianCalendar fechaOrigen) {
		this.fechaOrigen = fechaOrigen;
	}

	public GregorianCalendar getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(GregorianCalendar fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

	
	
}
