package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import funciones.Funciones;

public class Empleado {

	private int idEmpleado;
	private GregorianCalendar fechaIngreso;	
	private String apellido;
	private String nombre; 
	private int dni; 
	private String telefono;
	private TipoEmpleado tipoEmpleado;
	private Login login;
	
	public Empleado(){} // CONSTRUCTOR HIBERNATE 

	public Empleado(GregorianCalendar fechaIngreso, String apellido, String nombre, int dni,
			String telefono, TipoEmpleado tipoEmpleado, Login login) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.tipoEmpleado = tipoEmpleado;
		this.login = login;
	}
	
	//Hay empleados que no van a tener login. Si bien muchos van a interactuar con el sistema, hay algunos que no. Con el constructor de arriba estamos
	// obligando a que todos los empleados tengan login (además es como que también estoy obligando a conocer el login de antemano). Creo abajo un constructor sobrecargado sin login. 
	// Podria hasta incluso tener un solo constructor sin login (osea siempre iniciarlo en nulo) y despues setearselo a los empleados que si van a tener etc pero bueno. Con un sobrecargado creo que resolvemos todo.  
	
	public Empleado(GregorianCalendar fechaIngreso, String apellido, String nombre, int dni,
			String telefono, TipoEmpleado tipoEmpleado) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.tipoEmpleado = tipoEmpleado;
		this.login = null;	
	}
	
	public int getIdEmpleado() {
		return idEmpleado;	
	}

	protected void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public GregorianCalendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Login getLogin() {	
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String toString(){
		return (" || idEmpleado: "+idEmpleado+" || fechaIngreso: "+Funciones.traerFechaCorta(fechaIngreso)+"|| Apellido: "+apellido+" || Nombre: "+nombre+
				" || Dni: "+dni+" || Telefono: "+telefono+" || TipoEmpleado: "+tipoEmpleado);
	
	}
	

	
} // end_class_Empleado