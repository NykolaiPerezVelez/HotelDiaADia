package test;

import java.util.GregorianCalendar;

import datos.AdmHotel;
import datos.Cliente;
import datos.Empleado;
import datos.Login;
import datos.Permiso;
import datos.Temporada;
import datos.TipoEmpleado;
import datos.TipoHabitacion;
import datos.TipoHabitacionXTemporada;
import funciones.Funciones;
import negocio.EstadiaABM;		

public class TestFacturarEstadia {				
	public static void main(String[] args) {
		
		EstadiaABM estadiaABM = new EstadiaABM();
		//Esto es codigo de TestEstadia. Lo uso para crear la misma estadia que antes. 	
		System.out.println(" *************** Simulamos crear una estadia desde web (sin empleado) *****************");
		AdmHotel admHotel = new AdmHotel();					
		Cliente cliente = new Cliente("Potter", "Harry", 23213, "213123");			
		GregorianCalendar fechaCreacion = new GregorianCalendar();		
		GregorianCalendar diaCheckIn = new GregorianCalendar(2016, 4, 15);
		GregorianCalendar diaCheckOut = new GregorianCalendar(2016, 4, 22);	
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
		
		System.out.println("\n ************** Facturamos la estadia ***************");
		//Agrego los parametros nuevos.
		GregorianCalendar fechaInicioTemp1 = new GregorianCalendar(2016, 4, 14);	
		GregorianCalendar fechaFinTemp1 = new GregorianCalendar(2016, 4, 20); 				
		Temporada temporada1 = new Temporada("Baja", "Temporada baja", fechaInicioTemp1, fechaFinTemp1);
		
		GregorianCalendar fechaInicioTemp2 = new GregorianCalendar(2016, 4, 21);
		GregorianCalendar fechaFinTemp2 = new GregorianCalendar(2016, 4, 30);
		Temporada temporada2 = new Temporada("Media", "Temporada media", fechaInicioTemp2, fechaFinTemp2);
		admHotel.getTemporadas().add(temporada1);								
		admHotel.getTemporadas().add(temporada2);
		admHotel.getTipoHabitacionesXtemporada().add(new TipoHabitacionXTemporada(gryffindorBase, temporada1, 100));
		admHotel.getTipoHabitacionesXtemporada().add(new TipoHabitacionXTemporada(gryffindorBase, temporada2, 200));
		
		System.out.println("\n Datos a recordar: ");
		System.out.println("\n CheckIn de la estadia: "+Funciones.traerFechaCorta(diaCheckIn));
		System.out.println("\n CheckOut de la estadia: "+Funciones.traerFechaCorta(diaCheckOut));
		System.out.println("\n [Temporada 1] || Comienzo: "+Funciones.traerFechaCorta(fechaInicioTemp1)+" || Fin: "+Funciones.traerFechaCorta(fechaFinTemp1));
		System.out.println("\n [Temporada 2] || Comienzo: "+Funciones.traerFechaCorta(fechaInicioTemp2)+" || Fin: "+Funciones.traerFechaCorta(fechaInicioTemp2));
		System.out.println("\n");
		//Vamos a utilizar a "Dumbledore" para tener un empleado que facture la estadia. 
		estadiaABM.facturarEstadia(admHotel.traerEstadia(cliente), loginDumbledore, admHotel.getTemporadas(), admHotel.getTipoHabitacionesXtemporada());
		System.out.println(cliente.getCuentaCorriente()); //A ver si se cargo la factura...		 
		
																	
	} // end_public_main
} // end_class_TestGenerarFactura