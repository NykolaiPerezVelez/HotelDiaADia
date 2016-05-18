package negocio;

import org.hibernate.HibernateException;

import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class ClienteABM {
	private ClienteDao dao1 = new ClienteDao();
	private EventoDao dao = new EventoDao();
		
	public Cliente traerCliente(long idCliente){
		return dao1.traerCliente(idCliente);			
	}
    
	public Cliente traerClienteYEventos(long idCliente){
		return dao1.traerClienteYEventos(idCliente);				
	}			
	
	public boolean agregarEventoACliente(long idCliente, long idEvento) throws HibernateException, Exception{
		boolean agregado = false; 					
		Cliente cliente = dao1.traerClienteYEventos(idCliente);	
		Evento evento = dao.traerEventoYClientes(idEvento);			
		if (cliente.agregarEvento(evento) == true){	
			dao1.actualizar(cliente);			
			agregado = true;		 				
		}
		return agregado;				 		
	}
	
	public boolean eliminarEventoCliente(long idCliente,long idEvento) throws Exception {
		boolean eliminado = false; 		
		Cliente cliente = dao1.traerClienteYEventos(idCliente);
		Evento evento = dao.traerEventoYClientes(idEvento);
		eliminado = cliente.eliminarEvento(evento);	
		if (eliminado == true){
			dao1.actualizar(cliente);
		}
		return eliminado;			
	}
		
}
