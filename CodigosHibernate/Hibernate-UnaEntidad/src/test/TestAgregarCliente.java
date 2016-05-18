package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {	
		try{
			String apellido= "Torrent";		
			String nombre= "Marcos";
			int documento= 35000000;
			GregorianCalendar fechaDeNacimiento=new GregorianCalendar(1994, 0, 14);//tu fecha de nacimiento
			ClienteABM abm= new ClienteABM();
			long ultimoIdCliente= abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
			System.out.println("Ultimo id cliente: "+ ultimoIdCliente); //Coloco esta linea de codigo para que la clase no me quede con el icono de "atención" (ultimoIdCliente se declaraba pero despues no se usaba). 
		}
		catch (Exception e){
			System.out.println(e.getMessage());				
		}
	}
}

  		