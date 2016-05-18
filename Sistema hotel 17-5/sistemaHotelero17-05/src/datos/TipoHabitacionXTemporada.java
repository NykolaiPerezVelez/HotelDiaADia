package datos;

public class TipoHabitacionXTemporada { //Bien. Es necesario crear esta clase porque la tabla intermedia agrega nuevos atributos. 
																			
	private int idTipoHabitacionXTemporada;																												  				
	private TipoHabitacion tipoHabitacion;
	private Temporada temporada;
	private double precio;					
	
	public TipoHabitacionXTemporada(){} // CONSTRUCTOR HIBERNATE
	
	public TipoHabitacionXTemporada(TipoHabitacion tipoHabitacion, Temporada temporada, double precio) {
		this.tipoHabitacion = tipoHabitacion;
		this.temporada = temporada;
		this.precio = precio;
	}

	public int getIdTipoHabitacionXTemporada() {	
		return idTipoHabitacionXTemporada;
	}

	protected void setIdTipoHabitacionXTemporada(int idTipoHabitacionXTemporada) { //Coincido. Protected 
		this.idTipoHabitacionXTemporada = idTipoHabitacionXTemporada;
	}

	public TipoHabitacion getTipoHabitacion() {																
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;				
	}

	public double getPrecio() {			
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

} // end_class_TipoHabitacionXTemporada