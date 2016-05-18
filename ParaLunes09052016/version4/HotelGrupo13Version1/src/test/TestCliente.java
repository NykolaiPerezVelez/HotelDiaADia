package test;


import negocio.ClienteABM;

public class TestCliente {	
	public static void main(String[] args) {	
		try{
			String apellido= "Viki";								
			String nombre= "XipoLitaki";						
			int dni= 13456;
			String tel ="hola";
			
			
			
			ClienteABM abm= new ClienteABM();
			long ultimoIdCliente= abm.agregar(0, 0, apellido, nombre, dni, tel);
			
			System.out.println("Ultimo id cliente: "+ ultimoIdCliente); 
		}
		catch (Exception e){			
			System.out.println(e.getMessage());							
		}
	}
}
