package test;

import negocio.ClienteABM;

public class TestTraerClienteYEventos {
	public static void main (String [] args){ 
		//Probamos primero con Pablo Narvaja
		long idCliente = 2; 
		ClienteABM abmc = new ClienteABM();
		System.out.println("\n"+abmc.traerClienteYEventos(idCliente).toStringConEventos()+"\n");
		
		//Probamos con Jaramillo	
		idCliente = 1;
		System.out.println("\n"+abmc.traerClienteYEventos(idCliente).toStringConEventos());
	}
}	
