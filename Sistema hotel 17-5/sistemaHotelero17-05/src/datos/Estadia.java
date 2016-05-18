package datos;

import java.util.GregorianCalendar;
import java.util.List;
import funciones.Funciones;

import java.util.ArrayList;

public class Estadia {
	
	private int idEstadia;				
	private Cliente cliente;
	private Login empleado;
	private GregorianCalendar fechaCreacion;
	private GregorianCalendar fechaBaja;
	private GregorianCalendar diaCheckIn;	
	private GregorianCalendar diaCheckOut;
	private int cantidadAdultos;			
	private int cantidadNinios; 							 
	private List<TicketConsumo> ticketsConsumos;		
	private Habitacion habitacion;			 
	private boolean aceptada; 	
	private boolean activa;				 		

	public Estadia(){} // CONSTRUCTOR HIBERNATE			
	
	//Estadia con empleado -> Creada directamente desde la recepcion.	
	
	public Estadia(Cliente cliente, Login empleado, GregorianCalendar fechaCreacion, GregorianCalendar diaCheckIn, 
			GregorianCalendar diaCheckOut, int cantidadAdultos, int cantidadNinios, TipoHabitacion tipoHabitacion) {
		super();																	
		this.cliente = cliente;																		
		this.empleado = empleado;
		this.fechaCreacion = fechaCreacion;			
		this.fechaBaja = null; 										
		this.diaCheckIn = diaCheckIn;	
		this.diaCheckOut = diaCheckOut;
		this.cantidadAdultos = cantidadAdultos;
		this.cantidadNinios = cantidadNinios;		 
		this.ticketsConsumos = new ArrayList<TicketConsumo>();	
		this.setHabitacion(tipoHabitacion); 
		this.aceptada = true;		 						
		this.activa = true; 
	}						
	
	//Estadia sin empleado -> Creada via web.				
	
	public Estadia(Cliente cliente, GregorianCalendar fechaCreacion, GregorianCalendar diaCheckIn, 
			GregorianCalendar diaCheckOut, int cantidadAdultos, int cantidadNinios, TipoHabitacion tipoHabitacion) {
		super();					
		this.cliente = cliente;
		this.empleado = null; 	
		this.fechaCreacion = fechaCreacion;
		this.fechaBaja = null; 											
		this.diaCheckIn = diaCheckIn;
		this.diaCheckOut = diaCheckOut;
		this.cantidadAdultos = cantidadAdultos;
		this.cantidadNinios = cantidadNinios; 		
		this.ticketsConsumos = new ArrayList<TicketConsumo>();			
		this.setHabitacion(tipoHabitacion);  //Le asigna cualquier habitacion. Se hace más que nada para guardar en algun lado el tipoHabitacion.
		//Este tipo de habitacion que aproveche y lo "guarde" de esa forma, lo voy a necesitar en comenzarEstadiaAceptada() por si acepto la estadia. 	
		this.aceptada = false;	  					  	
		this.activa = false;						
	}			
	 
	//Le asigna una habitacion a la estadia automaticamente	 			
	public void setHabitacion(TipoHabitacion tipoHabitacion) {				
		int i = 0;				
		List<Habitacion> habitaciones = tipoHabitacion.getHabitaciones();
		for (i= 0; i< habitaciones.size(); i++){
			if (habitaciones.get(i).isOcupada() == false){		
				habitacion = habitaciones.get(i);
				if (empleado != null){ //Osea que la reserva se creo fisicamente y ya la gente esta ahi...	
					habitaciones.get(i).setOcupada(true); //Indico que la habitacion esta ocupada.   			
				}			
			}		
		}
	}							
	
	////////////////////////////// Para estadias creadas via Web: 
	
	public void aceptarEstadia(Login empleado){	
		this.empleado = empleado; //Empleado que la acepta. 	
		this.aceptada = true;		
	}
	
	public void comenzarEstadiaAceptada(){	
		if (aceptada == true){ //Aparte de estar aceptada, la persona que reservo vino fisicamente al hotel. Ahora si le asignamos bien la habitacion. 
			if (habitacion.isOcupada() == true){ //Si la habitacion que le habia asignado antes simplemente para guardar que tipo de habitacion era se ocupo. 
				setHabitacion(habitacion.getTipoHabitacion()); //Le doy una nueva habitacion vacia de ese mismo tipo. 
			}
			activa = true;										 		
		}
	}	
	
	public void cancelarEstadia(){
		this.fechaBaja = new GregorianCalendar();																	
	}				
	
	//////////////////////////////
	
	public void agregarTicketConsumo(Producto producto, int cantidad){											
		float total = producto.getPrecio() * cantidad;																											
		TicketConsumo ticket = new TicketConsumo(producto, this, cantidad, total);				
		ticketsConsumos.add(ticket);																			
	}		
		
	public int getIdEstadia() {	
		return idEstadia;
	}

	protected void setIdEstadia(int idEstadia) { 
		this.idEstadia = idEstadia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Login getLogin() {
		return empleado;				
	}

	public void setLogin(Login empleado) {
		this.empleado = empleado;
	}

	public GregorianCalendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(GregorianCalendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public GregorianCalendar getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(GregorianCalendar fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public GregorianCalendar getDiaCheckIn() {
		return diaCheckIn;
	}

	public void setDiaCheckIn(GregorianCalendar diaCheckIn) {
		this.diaCheckIn = diaCheckIn;
	}

	public GregorianCalendar getDiaCheckOut() {
		return diaCheckOut;
	}

	public void setDiaCheckOut(GregorianCalendar diaCheckOut) {
		this.diaCheckOut = diaCheckOut;
	}

	public int getCantidadAdultos() {
		return cantidadAdultos;
	}

	public void setCantidadAdultos(int cantidadAdultos) {
		this.cantidadAdultos = cantidadAdultos;
	}

	public int getCantidadNinios() {
		return cantidadNinios;
	}

	public void setCantidadNinios(int cantidadNinios) {
		this.cantidadNinios = cantidadNinios;
	}

	public List<TicketConsumo> getTicketsConsumos() {
		return ticketsConsumos;																									
	}

	protected void setTicketsConsumos(List<TicketConsumo> ticketsConsumos) {
		this.ticketsConsumos = ticketsConsumos;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public boolean isAceptada() {
		return aceptada;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	public boolean isActiva() {			
		return activa;	
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	public String toString(){			
		return ("\nidEstadia: "+idEstadia+"||\n Cliente: "+cliente+" ||\n Empleado: "+empleado+" ||\n FechaCreacion: "+Funciones.traerFechaCorta(fechaCreacion)+
				" ||\n FechaBaja: "+fechaBaja+" ||\n CheckIn: "+Funciones.traerFechaCorta(diaCheckIn)+
				" ||\n CheckOut: "+Funciones.traerFechaCorta(diaCheckOut)+" ||\n Cantidad adultos: "+cantidadAdultos+" ||\n Cantidad ninios: "+cantidadNinios+
				" ||\n TicketsConsumo: "+ticketsConsumos+" ||\n Habitacion:  "+habitacion+" ||\n Aceptada: "+aceptada+" ||\n Activa: "+activa);	
	}
		
} // end_class_Estadia