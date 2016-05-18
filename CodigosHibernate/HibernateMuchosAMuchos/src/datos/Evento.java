package datos; 

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Evento { //NUNCA MOSTRAR MENSAJES EN LA CAPA DE DATOS (SOLO EXCEPCIONES)
	private long idEvento;
	private String evento;
	private GregorianCalendar fecha;
	private Set<Cliente> clientes;
	
	public Evento(){}
	
	public Evento(String evento, GregorianCalendar fecha) {
		super();
		this.evento = evento;
		this.fecha = fecha;
	}
	
	public long getIdEvento() {
		return idEvento;
	}
	
	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	
	public String getEvento() {
		return evento;
	}
	
	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	public Set<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public boolean equals(Object e){
		return evento.equalsIgnoreCase(((Evento)e).getEvento());
	}
	
	public boolean agregarCliente(Cliente cliente){
		boolean agregado = false;
		//Vamos a agregar toda la informacion necesaria sobre los objetos en memoria 
		if (clientes.contains(cliente) == false){
			clientes.add(cliente); //Podria no necesitar preguntar si esta con un contains() debido a que el add no agrega elementos que ya esten en un set (usa equals)
			agregado = true; 	
			//System.out.println("Acabamos de agregar el cliente a la lista de clientes del evento [En memoria]");
		}				
		return agregado;	 		
	}
	
	public boolean eliminarCliente(Cliente cliente) {	
		//System.out.println("EliminarCliente [datos.Evento]"); 
		
		boolean eliminado = false; 
		
		//System.out.println("Cliente a borrar de memoria:" + cliente);
		
		for (Cliente c: clientes){
			//System.out.println("Cliente en la lista:"+ c);
			if (c.equals(cliente)){	
				eliminado = clientes.remove(c);	
				//System.out.println("¿Lo encontro y lo borro?: "+eliminado);
				break; 
			}
		} 	
		if (eliminado == false){
			System.out.println("El cliente que quieres eliminar no esta en la lista de clientes de este evento"); //También no me parece digo de cortar el flujo del programa
		}
		//System.out.println("Eliminado: "+eliminado);
		return eliminado;	 			
	}	
	
	public String toString(){
		return idEvento+" "+evento+" "+Funciones.traerFechaCorta(fecha)+""+Funciones.traerHora(fecha);
	}
	
	public String toStringConClientes(){
		return idEvento+" "+evento+" "+Funciones.traerFechaCorta(fecha)+""+Funciones.traerHora(fecha)+""+clientes;
	}
}