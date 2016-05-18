package test;

import java.util.GregorianCalendar;

import datos.AdmHotel;
import datos.Empleado;
import datos.TipoEmpleado;
import datos.TipoHabitacion;

public class TestGestionMucamas {

	public static void main(String[] args) {
	
		//Clase trabajadora
		AdmHotel admHotel = new AdmHotel();
		
		//Creo un tipohabitacion
		TipoHabitacion t1 = new TipoHabitacion ("Fea", "Se caen las paredes", 3,"Con suerte tiene agua");
		
		//Agrego una habitacion de ese tipo
		admHotel.agregarHabitacion(t1);
		
		//Primero genero el tipoEmpleado Mucama, y algun otro
		TipoEmpleado tipoM = new TipoEmpleado ("Mucama", "Limpiaaa!!!! mas rapidooo!!!!");
		TipoEmpleado tipoT = new TipoEmpleado ("Tecnico", "Este arregla cosas");
	
		
		//Creo permisos
		admHotel.agregarPermisos("Dios");
		admHotel.agregarPermisos("TrabajadorPosta");
		admHotel.agregarPermisos("Ñoqui");
		

		//Genero la lista de empleados
		admHotel.agregarEmpleado(new GregorianCalendar (2016,0,3), "Perez", "Nico", 1, "1111", tipoM);
		admHotel.agregarEmpleado(new GregorianCalendar (2016,10,13), "Torrent", "Brenda", 2, "2222", tipoT);
		admHotel.agregarEmpleado(new GregorianCalendar (2011,11,13), "Madeo", "Leandro", 3, "3333", tipoM);
		
		
		//Le doy login a cada uno
		admHotel.agregarLogin("Usuario1", "pass1", "Acordate1",admHotel.getEmpleados().get(0), admHotel.getPermisos().get(0));
		admHotel.agregarLogin("Usuario2", "pass2", "Acordate2",admHotel.getEmpleados().get(1), admHotel.getPermisos().get(1));
		admHotel.agregarLogin("Usuario3", "pass3", "Acordate3",admHotel.getEmpleados().get(2), admHotel.getPermisos().get(2));
		//Aca meto mano al constructor de Login
		
	
		//Muestro los empleados
		System.out.println("/////////////MUESTRO todos mis empleados//////////////");
		for (Empleado m: admHotel.getEmpleados()){
			System.out.println(m);}
		System.out.println("////////////////////////////////////////////////////");
		
		
		//Muestro solo las mucamas mucamas en columna
		System.out.println("/////////////MUESTRO DE MIS EMPLEADOS LAS MUCAMAS//////////////");
		for (Empleado m: admHotel.traerMucamas()){
			System.out.println(m);}
		System.out.println("////////////////////////////////////////////////////");
		
		
		
		//Cual es la mejor mucama para asignarle una habitacion????
		System.out.println("/////////////ESTA ES LA MEJOR MUCAMA PARA ASIGNAR A UNA HABITACION//////////////");
		System.out.println(admHotel.traerMucamaMasDisponible());
		System.out.println("///////////////////////////////////////////////////////");
		
		
		//Bueno ahora asignemosle una habitacion
		System.out.println("/////////////Le asigno una habitacion a la mucama mas vaga//////////////");
		System.out.println("/////////////ahora la mucama mas disponible es: //////////////");
		admHotel.asignarMucamaAHabitacion(admHotel.getHabitaciones().get(0));
		System.out.println(admHotel.traerMucamaMasDisponible());
		System.out.println("///////////////////////////////////////////////////////");
		
		
	}

}