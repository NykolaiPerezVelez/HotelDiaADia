package datos;

import java.util.GregorianCalendar;
import funciones.Funciones; 

public class Cliente {
	private long idCliente;
	private String apellido;	
	private String nombre;
	private int dni;
	private GregorianCalendar fechaDeNacimiento;
	private boolean baja;

	public Cliente(){} //siempre hay que implementar un contructor vacio 
	
	/*Todas las clases persistentes deben tener un constructor predeterminado (el cual puede ser no-público)
	de modo que Hibernate pueda instanciarlas usando Constructor.newInstance(). */
	
	public Cliente(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) {//nunca va el id en el constructor por ser autoincrementable -> ¿De asignar el id se encargara MySql?
	
	super(); //¿Por qué se pone esto si no hay una super-clase? -> ¿Va a haber una?
	this.apellido = apellido;
	this.nombre = nombre;
	this.dni= dni;	
	this.fechaDeNacimiento = fechaDeNacimiento;
	this.baja= false; //Utilizamos este atributo para indicar una baja logica. 
	
	}
		
	public long getIdCliente() {
		return idCliente;
	}		

	protected void setIdCliente(long idCliente) {//siempre va protected, para que no sea modificado <- //Si no tiene que ser modificado nunca, ¿no es mejor ni crear este metodo? 
		this.idCliente = idCliente;
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
	
	public GregorianCalendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento) { //¿No seria mejor un metodo que reciba 3 enteros y, en base a eso, crear la fecha? 
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public boolean isBaja() { //También podria ser getEstadoBaja() 
		return baja;
	}
	
	public void setBaja(boolean baja) { //Podria no recibir parametros y directamente setear la baja en "True" pero entonces también necesitariamos un setAlta();
		this.baja = baja;
	}
	
	public String toString(){
		return (idCliente+" "+apellido+" "+nombre+" DNI: "+dni+" F.de Nacimiento:"+Funciones.traerFechaCorta(fechaDeNacimiento)+" "+baja);
	}
}