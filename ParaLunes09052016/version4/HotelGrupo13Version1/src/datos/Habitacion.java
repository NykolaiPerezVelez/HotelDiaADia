package datos;

import java.util.Set;

public class Habitacion {

	
	private long idHabitacion;
	private boolean dispinibilidad;
	
	
	//Relaciones
	private Login login;
	private Set<Estadia> estadias;
	private TipoHabitacion tipoHabitacion;
	private Set<Limpieza> limpiezas;
	private Set<ParteReparacion> parteReparaciones;
	
	//Constructores
	public Habitacion(boolean dispinibilidad, Login login, Set<Estadia> estadias, TipoHabitacion tipoHabitacion) {
		this.dispinibilidad = dispinibilidad;
		this.login = login;
		this.estadias = estadias;
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public Habitacion(){}

	
	//Get y sets
	public long getIdHabitacion() {
		return idHabitacion;
	}

	protected void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public boolean getDispinibilidad() {
		return dispinibilidad;
	}

	public void isDispinibilidad(boolean dispinibilidad) {
		this.dispinibilidad = dispinibilidad;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Set<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(Set<Estadia> estadias) {
		this.estadias = estadias;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Set<Limpieza> getLimpiezas() {
		return limpiezas;
	}

	public void setLimpiezas(Set<Limpieza> limpiezas) {
		this.limpiezas = limpiezas;
	}

	public Set<ParteReparacion> getParteReparaciones() {
		return parteReparaciones;
	}

	public void setParteReparaciones(Set<ParteReparacion> parteReparaciones) {
		this.parteReparaciones = parteReparaciones;
	}
	
	
	
	
	
	
}
