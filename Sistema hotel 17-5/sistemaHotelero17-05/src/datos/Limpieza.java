package datos;

import java.util.GregorianCalendar;

public class Limpieza {
	
	private int idLimpieza;	
	private GregorianCalendar fecha;
	private Habitacion habitacion;	
	private TipoLimpieza tipoLimpieza; 	 
	private boolean limpia;		

	public Limpieza(){} // CONSTRUCTOR HIBERNATE
	
	//Lo mismo que antes. "Boolean limpia" como parametro serviria para los casos en que JUSTO implementamos el sistema despues de que una mucama haya limpiado una habitacion.
	// Algo bastante raro. El 99% de los casos que se creen registros de Limpieza (que se van a ir agregando cada dia nuevos) van a empezar con limpia = false y, cuando las mucamas limpien esa habitacion, lo setearan a "true" 
	
	/*Encontre el constructor asi:
	public Limpieza(int idLimpieza, GregorianCalendar fecha, Habitacion habitacion, TipoLimpieza tipoLimpieza,
			boolean limpia) { 
		super();
		this.idLimpieza = idLimpieza;
		this.fecha = fecha;
		this.habitacion = habitacion;
		this.tipoLimpieza = tipoLimpieza;
		this.limpia = limpia;		
	}
	*/
	
	//Para mi es asi:						
	public Limpieza(int idLimpieza, GregorianCalendar fecha, Habitacion habitacion, TipoLimpieza tipoLimpieza) { 
		super();
		this.idLimpieza = idLimpieza;
		this.fecha = fecha;
		this.habitacion = habitacion;
		this.tipoLimpieza = tipoLimpieza;
		this.limpia = false; 
	}				
		

	public int getIdLimpieza() {
		return idLimpieza;
	}

	protected void setIdLimpieza(int idLimpieza) {	//Estaba en public y lo cambie a protected. 
		this.idLimpieza = idLimpieza;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;	
	}

	public Habitacion getHabitacion() {
		return habitacion;		
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;		
	}

	public TipoLimpieza getTipoLimpieza() {
		return tipoLimpieza;
	}

	public void setTipoLimpieza(TipoLimpieza tipoLimpieza) {
		this.tipoLimpieza = tipoLimpieza;
	}

	public boolean isLimpia() {	
		return limpia;	
	}

	public void setLimpia(boolean limpia) {
		this.limpia = limpia;				
	}

} // end_class_Limpieza