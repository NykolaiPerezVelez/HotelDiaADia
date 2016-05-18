package negocio;

import org.hibernate.HibernateException;

import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;	

public class EventoABM { //EN NEGOCIO TAMPOCO SE MUESTRAN MENSAJES. A LO SUMO LEVANTA EXCEPCIONES 
	private EventoDao dao= new EventoDao();
	private ClienteDao dao1 = new ClienteDao(); 					
	
	public boolean agregarClienteAEvento(long idEvento, long idCliente) throws HibernateException, Exception{ //¿Yo le paso los id's por teclado o estos id's son los que el sistema extra automaticamente de dos objetos seleccionados en memoria? 	
		boolean agregado = false; 					
		Cliente cliente = dao1.traerClienteYEventos(idCliente); //Tiene relacion con lo comentado arriba. 		
		//System.out.println("Cliente que vamos a agregar a un evento: "+cliente);
		Evento evento = traerEventoYClientes(idEvento);		
		//System.out.println("Evento al cual vamos a agregarlo: "+evento);
		if (evento.agregarCliente(cliente) == true){ //No es necesario actualizar, si el cliente que intentando agregar ya forma parte del evento 
			dao.actualizar(evento);					
			agregado = true;	 										
		}		
		//System.out.println("¿Hubo acceso a la base de datos?: "+agregado);
		return agregado; 					
	}
		
	public boolean eliminarClienteAEvento(long idEvento, long idCliente) throws Exception {
		
		//System.out.println("EliminarClienteAEvento [EventoABM]");
		
		boolean eliminado = false;	 	
		Cliente cliente = dao1.traerClienteYEventos(idCliente);	
		
		//System.out.println("Cliente que queremos borrar: "+cliente);
		
		Evento evento = dao.traerEventoYClientes(idEvento);
		
		//System.out.println("Evento del cual queremos borrar al cliente: "+evento);
		
		eliminado = evento.eliminarCliente(cliente);
		
		//System.out.println("EliminarClienteAEvento [EventoABM]");
		//System.out.println("Eliminado:"+ eliminado);
		
		if (eliminado == true){			
			dao.actualizar(evento);	//Aca se tiene que actualizar. 					
		}		
		return eliminado; 						
	}
	
	public Evento traerEventoYClientes(long idEvento){
		return dao.traerEventoYClientes(idEvento);			
	}
	
	public Evento traerEvento(long idEvento){
		return dao.traerEvento(idEvento);
	}	
}
