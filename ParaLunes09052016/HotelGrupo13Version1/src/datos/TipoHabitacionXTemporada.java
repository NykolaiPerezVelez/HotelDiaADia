package datos;

public class TipoHabitacionXTemporada {
	
	private long idTipoHabitacionXTemporada;
	private float precioNoche;
	
	//Relaciones
	private TipoHabitacion tipoHabitacion;
	private Temporada temporada;
	
	//Constructores
	public TipoHabitacionXTemporada(float precioNoche, TipoHabitacion tipoHabitacion, Temporada temporada) {
		this.precioNoche = precioNoche;
		this.tipoHabitacion = tipoHabitacion;
		this.temporada = temporada;
	}
	
	
	public TipoHabitacionXTemporada(){}

	//Gets y sets

	public long getIdTipoHabitacionXTemporada() {
		return idTipoHabitacionXTemporada;
	}


	protected void setIdTipoHabitacionXTemporada(long idTipoHabitacionXTemporada) {
		this.idTipoHabitacionXTemporada = idTipoHabitacionXTemporada;
	}


	public float getPrecioNoche() {
		return precioNoche;
	}


	public void setPrecioNoche(float precioNoche) {
		this.precioNoche = precioNoche;
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
	
	
	
	
	
	
	

}
