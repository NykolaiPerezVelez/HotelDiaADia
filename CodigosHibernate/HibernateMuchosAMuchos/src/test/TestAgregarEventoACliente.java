package test;

import negocio.ClienteABM;

public class TestAgregarEventoACliente {
	public static void main (String[] args){
		try{ //Intentamos agregar un evento que existe a un cliente que existe
			ClienteABM clienteABM = new ClienteABM();
			long idCliente = 1; //Este cliente existe en la base de datos	
			long idEvento = 1;  //Este evento existe en la base de datos	
			clienteABM.agregarEventoACliente(idCliente, idEvento);	
		}
		catch (Exception e){		
			System.out.println(e.getMessage());		
		}
		try{ //Intengamos agregar un evento que no existe a un cliente que existe
			System.out.println("\n\n");
			ClienteABM clienteABM = new ClienteABM();
			long idCliente = 1; //Este cliente existe en la base de datos	
			long idEvento = 4;  //Este evento existe en la base de datos
			clienteABM.agregarEventoACliente(idCliente, idEvento);			
		}		
		catch (Exception e){
			System.out.println(e.getMessage());		
		}	
	}
}
