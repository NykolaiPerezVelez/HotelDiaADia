package test;

import negocio.EventoABM;

public class TestEliminarClienteEvento {
	public static void main (String[] args){
		try{ //Como antes en "TestAgregarClienteEvento" habiamos agregado al evento con id = 1 el cliente con id = 1, ahora vamos a borrarlo... 
			EventoABM abme = new EventoABM(); //Creamos un eventoABM para poder trabajar con la informacion 
			long idCliente = 1;
			long idEvento =  1;	
			abme.eliminarClienteAEvento(idEvento, idCliente); //Intentamos eliminar el cliente 1 del evento 1. 
		}
		catch(Exception e){						
			System.out.println(e.getMessage());	
		}	
		try{ //Ahora vamos a ver que pasa si queremos borrar el cliente de un evento que no lo tenga.. (podemos utilizar los mismos valores (idEvento = 1 e idCliente = 1) el try anterior los borro... 
			System.out.println("\n\n"); 
			EventoABM abme = new EventoABM(); 
			long idCliente = 1;
			long idEvento =  4;		
			abme.eliminarClienteAEvento(idEvento, idCliente);
		}
		catch(Exception e){
			System.out.println(e.getMessage());	
		}
	}	
}	
