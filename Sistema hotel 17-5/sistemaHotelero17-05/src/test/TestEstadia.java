package test;	

import java.util.GregorianCalendar;

import datos.AdmHotel;	
import datos.Cliente;
import datos.Empleado;
import datos.Login;
import datos.Permiso;
import datos.Servicio;
import datos.TipoEmpleado;
import datos.TipoHabitacion;		

public class TestEstadia {
	public static void main (String[] args){
		System.out.println(" *************** Simulamos crear una estadia desde web (sin empleado) *****************");
		AdmHotel admHotel = new AdmHotel();					
		Cliente cliente = new Cliente("Potter", "Harry", 23213, "213123");			
		GregorianCalendar fechaCreacion = new GregorianCalendar();		
		GregorianCalendar diaCheckIn = new GregorianCalendar(2016, 4, 16);
		GregorianCalendar diaCheckOut = new GregorianCalendar(2016, 4, 17);
		int cantidadAdultos = 1;		
		int cantidadNinios = 0;	
		
		
		TipoHabitacion gryffindorBase = new TipoHabitacion("GryffindorBase", "Mucha magia", 1, "Partidos televisados de Quidditch gratis");
		gryffindorBase.agregarHabitacion();	//No le pasa parametros porque se crean solas en la base de datos. 				
		admHotel.agregarEstadia(cliente, fechaCreacion, diaCheckIn, diaCheckOut, cantidadAdultos, cantidadNinios, gryffindorBase);	
		System.out.println(admHotel.traerEstadia(cliente).toString());	
		
		System.out.println("\n *********** Probamos aceptar la estadia **************"); 
		GregorianCalendar fechaIngreso = new GregorianCalendar(2014, 1, 20);
		TipoEmpleado tipo1 = new TipoEmpleado("Repecionista", "Corresponde al encargado de la recepcion");
		Empleado dumbledore = new Empleado (fechaIngreso, "Dumbledore", "Albus", 213123, "21312312", tipo1);
		Permiso permiso = new Permiso("Permiso prueba");
		Login loginDumbledore = new Login("usuario1", "contraseña1", "hogwarts", dumbledore, permiso);
		admHotel.traerEstadia(cliente).aceptarEstadia(loginDumbledore);		
		System.out.println(admHotel.traerEstadia(cliente)); 	
	
		System.out.println("\n *************** Cambiamos la estadia a ACTIVA *******************");	
		admHotel.traerEstadia(cliente).comenzarEstadiaAceptada();
		System.out.println(admHotel.traerEstadia(cliente));	
		
		System.out.println("\n ****************** Probamos agregarle consumos ******************");
		Servicio lavanderia = new Servicio("Lavanderia", "Lavado de prendas magicas");
		lavanderia.agregarProducto("Lavado de capa", "precio x unidad", 10);	
		admHotel.traerEstadia(cliente).agregarTicketConsumo(lavanderia.traerProducto("Lavado de capa"), 1);
		System.out.println(admHotel.traerEstadia(cliente));												
	}		
}
