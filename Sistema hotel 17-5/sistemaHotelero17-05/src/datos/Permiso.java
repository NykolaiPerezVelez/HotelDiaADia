package datos;

public class Permiso { //Bien. Me gusto la creacion de la clase "Permiso". Un empleado tiene un permiso pero el mismo permiso puede estar en varios empleados -> Da origen a una clase. 
	
	private int idPermiso;		
	private String descripcion;					
	
	public Permiso(){}; // CONSTRUCTOR HIBERNATE
	
	public Permiso(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	protected void setIdPermiso(int idPermiso) { //Coincido. Protected 
		this.idPermiso = idPermiso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
} // end_class_Permiso