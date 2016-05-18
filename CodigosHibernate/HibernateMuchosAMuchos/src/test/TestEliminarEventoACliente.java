package test;

import negocio.ClienteABM;

public class TestEliminarEventoACliente {
	public static void main (String[] args){
		try{ //Si utilizamos antes TestAgregarClienteEvento, tendremos que tener un registro en la tabla "eventoxcliente" con los valores idCliente = 1, IdEvento = 1. Vamos a borrar este registro
			ClienteABM cabm = new ClienteABM();	//¿Y como lo vamos a borrar? Elimiandole ese evento al cliente. 
			long idCliente = 1;
			long idEvento = 1;	
			cabm.eliminarEventoCliente(idCliente, idEvento);	
		}
		catch (Exception e){			
			System.out.println(e.getMessage());		
		}
		try{ //Intentemos borrar algo que no existe (Vamos a utilizar los mismos valores de arriba). El registro idEvento = 1, idCliente = 1 en la tabla intermedia no tendria que existir más si el anterior "try" se ejecuto correctamente
			System.out.println("\n\n");
			ClienteABM cabm = new ClienteABM();	//¿Y como lo vamos a borrar? Elimiandole ese evento al cliente. 
			long idCliente = 1;
			long idEvento = 1;		
			cabm.eliminarEventoCliente(idCliente, idEvento);
		}
		catch (Exception e){					
			System.out.println(e.getMessage());							
		}
	}	
}
