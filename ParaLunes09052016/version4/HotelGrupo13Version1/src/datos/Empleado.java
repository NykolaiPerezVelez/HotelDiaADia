package datos;

import java.util.GregorianCalendar;

public class Empleado {

	private long idEmpleado;
	private GregorianCalendar fechaIngresoHotel;
	private String apellido;
	private String nombre;
	private int dni;
	private String tel;
	
	//relaciones

	private Login login;
	private TipoEmpleado tipoEmpleado;
	
	
	//Constructores
	public Empleado(GregorianCalendar fechaIngresoHotel, Login login, TipoEmpleado tipoEmpleado) {
		this.fechaIngresoHotel = fechaIngresoHotel;

		this.login = login;
		this.tipoEmpleado = tipoEmpleado;
	}
	
	
	
	
	public Empleado(GregorianCalendar fechaIngresoHotel, String apellido, String nombre, int dni, String tel,
			Login login, TipoEmpleado tipoEmpleado) {
		super();
		this.fechaIngresoHotel = fechaIngresoHotel;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.tel = tel;
		this.login = login;
		this.tipoEmpleado = tipoEmpleado;
	}




	public Empleado(){}


	
	//gets y sets
	
	public long getIdEmpleado() {
		return idEmpleado;
	}


	protected void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public GregorianCalendar getFechaIngresoHotel() {
		return fechaIngresoHotel;
	}


	public void setFechaIngresoHotel(GregorianCalendar fechaIngresoHotel) {
		this.fechaIngresoHotel = fechaIngresoHotel;
	}





	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}


	public void setTipoPersona(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
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




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	
	

	
}
