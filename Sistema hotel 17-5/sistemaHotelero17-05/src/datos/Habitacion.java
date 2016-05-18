package datos;

public class Habitacion {
	
	private int idHabitacion;
	private TipoHabitacion tipoHabitacion;
	private Login mucama; 		//Esto en realidad no es un Empleado sino un Login. 	
	private boolean ocupada;				 
	
	public Habitacion(){} // CONSTRUCTOR HIBERNATE

	public Habitacion(TipoHabitacion tipoHabitacion) {	
		super();			 			
		this.tipoHabitacion = tipoHabitacion;							
		this.mucama = null; 					
		this.ocupada = false; 							
	}

	public int getIdHabitacion() {							
		return idHabitacion;
	}

	protected void setIdHabitacion(int idHabitacion) { //Coincido. Protected. 
		this.idHabitacion = idHabitacion;			
	}	

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public Login getLogin() { //En realidad aca no es getEmpleado, es getLogin(). 
		return mucama;	
	}

	public void setLogin(Login mucama) { //Lo mismo en este caso. 
		this.mucama = mucama;					
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}	
	
	public String toString(){
		return ("idHabitacion: "+idHabitacion+" || tipoHabitacion: "+tipoHabitacion+" || mucama: "+mucama+" || ocupada: "+ocupada);
	}
} // end_class_Habitacion