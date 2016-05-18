package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarCliente {	//ESTE ES EL PRIMER TEST QUE HAY QUE HACER. LA BASE DE DATOS EMPIEZA VACIA. HAY QUE FIJARSE QUE ID'S LE AGREGA A LOS CLIENTES PARA...	
	public static void main(String[] args) {	//... PODER CAMBIAR ALGUNOS NUMERITOS EN LOS TEST Y QUE FUNCIONE CORRECTAMENTE. SI LA BASE DE DATOS TENDRIA COSAS CARGADS POR DEFECTO, SERIA MÁS FACIL. NO HABRIA QUE CAMBIAR NADA. 
		try{
			String apellido= "Torrent";								
			String nombre= "Marcos";						
			int documento= 35000000;
			GregorianCalendar fechaDeNacimiento=new GregorianCalendar(1994, 0, 14);//tu fecha de nacimiento
			ClienteABM abm= new ClienteABM();
			long ultimoIdCliente= abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
			System.out.println("Ultimo id cliente: "+ ultimoIdCliente); //Coloco esta linea de codigo para que la clase no me quede con el icono de "atención" (ultimoIdCliente se declaraba pero despues no se usaba. Entonces, voy a usarlo aprovechando que lo puedo imprimir para saber cual fue el ultimo id que se guardo en la base de datos). 
		}
		catch (Exception e){			
			System.out.println(e.getMessage());							
		}
	}
}

  		