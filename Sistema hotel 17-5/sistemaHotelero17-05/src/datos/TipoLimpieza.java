package datos;

public class TipoLimpieza {			
	
	private int idTipoLimpieza;											
	private String nombreLimpieza;							
	private String descripcionLimpieza;					
	
	public TipoLimpieza(){} // CONSTRUCTOR HIBERNATE
	
	public TipoLimpieza(String nombreLimpieza, String descripcionLimpieza) {
		super();
		this.nombreLimpieza = nombreLimpieza;			
		this.descripcionLimpieza = descripcionLimpieza;
	}

	public int getIdTipoLimpieza() {
		return idTipoLimpieza;
	}

	protected void setIdTipoLimpieza(int idTipoLimpieza) { //Coincido. Protected 			
		this.idTipoLimpieza = idTipoLimpieza;
	}

	public String getNombreLimpieza() {							
		return nombreLimpieza;
	}

	public void setNombreLimpieza(String nombreLimpieza) {
		this.nombreLimpieza = nombreLimpieza;
	}

	public String getDescripcionLimpieza() {
		return descripcionLimpieza;
	}

	public void setDescripcionLimpieza(String descripcionLimpieza) {
		this.descripcionLimpieza = descripcionLimpieza;
	}				
	
} // end_class_TipoLimpieza
