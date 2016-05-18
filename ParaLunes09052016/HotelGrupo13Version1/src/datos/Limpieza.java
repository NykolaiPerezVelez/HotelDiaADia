package datos;

import java.util.GregorianCalendar;

public class Limpieza {
	
	private long idLimpieza;
	private boolean limpia;
	private GregorianCalendar fecha;
	private String tipoLimpieza;
	
	//Relaciones
	private Habitacion habitacion;

	
	//Constructores
	public Limpieza(boolean limpia, GregorianCalendar fecha, String tipoLimpieza, Habitacion habitacion) {
		this.limpia = limpia;
		this.fecha = fecha;
		this.tipoLimpieza = tipoLimpieza;
		this.habitacion = habitacion;
	}
	
	public Limpieza(){}
	
	//Gets y sets

	public long getIdLLimpieza() {
		return idLimpieza;
	}

	protected void setIdLLimpieza(long idLLimpieza) {
		this.idLimpieza = idLLimpieza;
	}

	public boolean isLimpia() {
		return limpia;
	}

	public void setLimpia(boolean limpia) {
		this.limpia = limpia;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public String getTipoLimpieza() {
		return tipoLimpieza;
	}

	public void setTipoLimpieza(String tipoLimpieza) {
		this.tipoLimpieza = tipoLimpieza;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
	
	

}
