package datos;

public class TipoEmpleado {
	
	private int idTipoEmpleado;
	private String nombreTipo;
	private String descripcionTipo;			
	
	public TipoEmpleado(){} // CONSTRUCTOR HIBERNATE

	public TipoEmpleado(String nombreTipo, String descripcionTipo) {
		super();
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;		
	}

	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}
	
	protected void setIdTipoEmpleado(int idTipoEmpleado) { //Coincido. Protected 
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;			
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}
	
	public String toString(){
		return ("idTipoEmplado: "+idTipoEmpleado+" || NombreTipo: "+nombreTipo+" || DescripcionTipo: "+descripcionTipo);				
	}	
	
} // end_class_TipoEmpleado