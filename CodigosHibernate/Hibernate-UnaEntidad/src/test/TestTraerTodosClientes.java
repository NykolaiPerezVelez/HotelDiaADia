package test;

import negocio.ClienteABM;

public class TestTraerTodosClientes {
	public static void main (String[] args){
		ClienteABM abm = new ClienteABM();
		System.out.println("Lista de clientes: " + abm.traerCliente());	
	}
}
																				