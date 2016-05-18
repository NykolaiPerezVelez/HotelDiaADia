package test;

import negocio.EventoABM;		

public class TestAgregarClienteEvento { //Agrega un cliente a un evento. 
	public static void main (String [] args){	
		try{
			long idCliente = 1;   //Jaramillo es el id = 1 y no tiene asignado ningun evento en la base de datos. 
			long idEvento = 1;   //En la base de datos hay un evento con id = 1
			EventoABM abme = new EventoABM();	
			abme.agregarClienteAEvento(idEvento, idCliente);	 				
		}
		catch (Exception e){	
			System.out.println(e.getMessage());
		}
		try { //Intentemos agregar un cliente a un evento que no existe...
			System.out.println("\n\n");
			long idCliente = 1;
			long idEvento = 4; //No hay eventos con id = 4 en la base de datos.
			EventoABM abme = new EventoABM();
			abme.agregarClienteAEvento(idEvento, idCliente);			
		}
		catch (Exception e){			
			System.out.println(e.getMessage());			
		}	
	}				
}
