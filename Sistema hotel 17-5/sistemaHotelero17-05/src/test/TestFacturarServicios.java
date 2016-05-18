package test;

import datos.Cliente;
import datos.Estadia;
import datos.FormaPago;
import datos.Habitacion;
import datos.Servicio;
import datos.TipoHabitacion;
import funciones.Funciones;
import negocio.FacturaABM;

public class TestFacturarServicios {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente(1,"Zalazar Madeo","Diego Leandro", 11111111, "1511111111", false);
		TipoHabitacion tipo1 = new TipoHabitacion(1,"Estandar doble", "Cama matrimonial", 2, "Frigobar, Internet,"
				+ "Television satelital");
		Habitacion habitacion1 = new Habitacion(1, tipo1, 200.00, true);
		FormaPago formaPago2 = new FormaPago(2, "Visa Debito");
		
		Estadia estadia1 = new Estadia(1, cliente1, Funciones.aGregorianCalendar(2016,05,01),
				Funciones.aGregorianCalendar(2016,05,04), 2, 0, formaPago2, habitacion1, true);
		FacturaABM factura2 = new FacturaABM();
		
		// GENERO LOS SERVICIOS
		
		Servicio servicio1 = new Servicio(1, "Spa", "Spa 1 Hora", 100.00, true);
		Servicio servicio2 = new Servicio(2, "CocaCoca500ml", "Botella500ml", 20.00, false);
		Servicio servicio3 = new Servicio(3, "CocaCoca330ml", "Lata330ml", 15.00, false);
		
		// CONSUMO 2 COCA COLA BOTELLA, 3 SERVICIOS DE SPA Y 1 LATA COCA COLA. GENERO LOS TICKETS CORRESPONDIENTES.
		
		estadia1.agregarTicketConsumo(1, servicio2, 2);
		estadia1.agregarTicketConsumo(2, servicio1, 3);
		estadia1.agregarTicketConsumo(3, servicio3, 1);
		
		System.out.println(factura2.facturarServicios(estadia1, formaPago2));

	} // end_public_main
} // end_class_TestFacturarServicios