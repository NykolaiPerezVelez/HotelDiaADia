package datos;

import java.util.Set;

public class TipoEmpleado {
	
	private long idTipoEmpleado;
	private String nombreTipo;
	
	
	//Relaciones
	private Set<Empleado> empleados;


	
	//Gets y sets
	public long getidTipoEmpleado() {
		return idTipoEmpleado;
	}


	protected void setidTipoEmpleado(long idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}


	public String getNombreTipo() {
		return nombreTipo;
	}


	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}


	public Set<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}


	//Constructores
	public TipoEmpleado(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	public TipoEmpleado(){}
	
	
	
	

}
