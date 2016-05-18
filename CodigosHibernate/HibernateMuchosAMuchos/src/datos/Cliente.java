package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Cliente {
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private GregorianCalendar fechaDeNacimiento;
	private boolean baja;
	private Set<Evento> eventos;
	
	public Cliente(){}
	
	public Cliente(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni= dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja= false;
	}
	
	public long getIdCliente() {
		return idCliente;
	}
	
	protected void setIdCliente(long idCliente) {
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
	
	public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public boolean isBaja() {
		return baja;
	}
	
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	public Set<Evento> getEventos() {
		return eventos;
	}
	
	protected void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}	
	
	@Override 
	public boolean equals(Object c) {
		return (dni == ((Cliente)c).getDni());	
	}

	public boolean agregarEvento(Evento evento){				 		
		boolean agregado = false; 				
		if (eventos.contains(evento) == false){
			eventos.add(evento);	
			agregado = true; 
		}
		return agregado; 			
	}

	public boolean eliminarEvento(Evento evento){
		
		//System.out.println("EliminarEvento [datos.Cliente]");		
		
		boolean eliminado = false; 	
		
		//System.out.println("Evento a borrar en memoria:"+evento); 
		
		for (Evento e: eventos){		
			//System.out.println("Evento de la lista: "+e);
			if (e.equals(evento)){		
				eliminado = eventos.remove(e);
				//System.out.println("¿Lo encontro y lo borro?: "+eliminado);
				break; 
			}	
		} 
		if (eliminado == false){		
			System.out.println("El evento que se intenta eliminar no esta en la lista de eventos de este cliente");	
		}	
		//System.out.println("Eliminado: "+eliminado);	
		return eliminado; 
	}
	
	public String toString(){
		return (idCliente+" "+apellido+" "+nombre+" DNI: "+dni+" F.de Nacimiento:"+Funciones.traerFechaCorta(fechaDeNacimiento)+" "+baja);
	}
	
	public String toStringConEventos(){
		return (idCliente+" "+apellido+" "+nombre+" DNI: "+dni+" F.de Nacimiento:"+Funciones.traerFechaCorta(fechaDeNacimiento)+" "+baja+""+eventos);
	}
}