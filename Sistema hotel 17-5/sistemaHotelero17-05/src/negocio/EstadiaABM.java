package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import datos.Estadia;
import datos.Factura;
import datos.Login;
import datos.Temporada;
import datos.TipoHabitacion;
import datos.TipoHabitacionXTemporada;
import datos.AdmHotel;
import funciones.Funciones;	

public class EstadiaABM {										
	
	AdmHotel admHotel = new AdmHotel();	
	
	public void facturarEstadia(Estadia estadia, Login login, ArrayList<Temporada> temporadas, ArrayList<TipoHabitacionXTemporada> habitacionesXtemporada){
		int cantidadDiasTemporada1 = 0;			
		int cantidadDiasTemporada2 = 0; 
		int i = 0; 	
		int j = 0;
		double precio = -1;						
		////////////
		TipoHabitacion tipoHabitacion = estadia.getHabitacion().getTipoHabitacion();
		GregorianCalendar fechaCheckIn = estadia.getDiaCheckIn(); //Ej: 16/05/16
		GregorianCalendar fechaCheckOut = estadia.getDiaCheckOut(); //Ej: 22/05/16
		GregorianCalendar fechaBase = fechaCheckIn;  //Fecha en base a la cual haremos calculos. 16/05/16
		//ArrayList<Temporada> temporadas = admHotel.getTemporadas(); 	
		//ArrayList<TipoHabitacionXTemporada> habitacionesXtemporada = admHotel.getTipoHabitacionesXtemporada();
		Temporada temporada1 = null;								
		Temporada temporada2 = null; 			
		///////////
		System.out.println("A ver si agarro el tipo de Habitacion: "+tipoHabitacion);
		System.out.println("A ver si agarro todas las temporadas: "+temporadas);
		System.out.println("A ver si agarro la lista de Habitaciones x temporada: "+habitacionesXtemporada);
			
			for (i= 0; i< temporadas.size(); i++){ //Recorremos la temporada. Supongamos que hay una temporada 1 asi -> FechaInicio = 15/05/16, FechaFin = 20/05/16 
				//Si 16/05/16 >= 15/05/16 y 16/05/16 <= 20/05/16
				if ((fechaBase.after(temporadas.get(i).getFechaInicio()) || Funciones.sonFechasIguales(fechaBase, temporadas.get(i).getFechaInicio())) && 
						(Funciones.sonFechasIguales(fechaBase, temporadas.get(i).getFechaFin()) || fechaBase.before(temporadas.get(i).getFechaFin()))){
					 		temporada1 = temporadas.get(i);	//La temporada a la que corresponde el primer dia de la estadia es esa. 
					 		cantidadDiasTemporada1++; //Ya decimos que hay un dia en esa temporada 
					//Mientras:
					// fechaBase (a la que se le iran sumando días) sea <= 20/05/16 (limite de la temporada)
					// Y
					// fechaBase no sobrepase fechaCheckOut (no tengo que contar dias de más) 
					while (((fechaBase.before(temporada1.getFechaFin()) || Funciones.sonFechasIguales(fechaBase, temporada1.getFechaFin())) &&
							(fechaBase.before(fechaCheckOut) || Funciones.sonFechasIguales(fechaBase, fechaCheckOut)))){		
						fechaBase.add(Calendar.DATE, 1); //Avanzo un dia (si se excede del fin de temporada, va a cortar)
						cantidadDiasTemporada1++;	//Sumo un dia más en esa temporada 
					}
					//Termina el while.
					//Ya tengo la cantidad de días para la temporada 1 (puede ser la unica si la estadia no comprende otra temporada más). 
					//Ya tengo la temporada. 
					//Ya tenia el tipo de habitacion							
					if (fechaBase.before(fechaCheckOut)){  //¿La fecha base es menor que la del CheckOut? (esto quiere decir que el While corto por temporada y quedan dias sin asignar)
						//FechaBase por logica tiene que estar parada en el primer dia de la temporada siguiente  
						temporada2 = temporadas.get(i+1); //Ya sabemos que vamos a tener otra temporada más que va a ser "i+1" 
						//Las temporadas se tienen que cargar en orden para permitir lo de "i+1" (de lo contrario seria más complejo)
						while (fechaBase.before(fechaCheckOut) || Funciones.sonFechasIguales(fechaBase, fechaCheckOut)){ //Mientras fechaBase <= fechaCheckOut
							fechaBase.add(Calendar.DATE, 1); //Sigo sumando días		
							cantidadDiasTemporada2++;	//Sumo un día más a esa temporada
						}
						//Termina el while
						//Tengo la cantidad de días para la temporada 2 (si es que existiese)
						//Tengo la temporada
						//Ya tenia el tipo de habitacion
					}
				}
				i = temporadas.size(); //Como ya tengo todos los datos que necesito, corto el "for".
			}
			Factura factura = new Factura(login, new GregorianCalendar(), estadia.getCliente()); //Creo la factura
			
			if (cantidadDiasTemporada2 == 0){ //Si la temporada 2 no tiene ningun dia -> El cliente uso una sola temporada. 
				for (j= 0; j<habitacionesXtemporada.size(); j++){	//Si encuentro la temporada y el tipo de Habitacion 
					if((habitacionesXtemporada.get(j).getTipoHabitacion() == tipoHabitacion) && (habitacionesXtemporada.get(j).getTemporada() == temporada1)){
								precio = habitacionesXtemporada.get(j).getPrecio();		//Obtengo el precio 
								j = habitacionesXtemporada.size(); //Corto el "for" para no recorrer de más
					}
				factura.agregarItem(1, temporada1.getNombre(), cantidadDiasTemporada1, precio);
				}
			}	
			if (cantidadDiasTemporada2 > 0){ //Si el cliente uso 2 temporadas... 							
				for (j= 0; j<habitacionesXtemporada.size(); j++){
					if (habitacionesXtemporada.get(j).getTipoHabitacion() == tipoHabitacion){ //Si el tipo de Habitacion es ese... 
						if (habitacionesXtemporada.get(j).getTemporada() == temporada1){ //Si encontramos la temporada 1. 
							precio = habitacionesXtemporada.get(j).getPrecio();		//Obtengo el precio
							factura.agregarItem(1, temporada1.getNombre(), cantidadDiasTemporada1, precio);
						}
						if (habitacionesXtemporada.get(j).getTemporada() == temporada2){	
							precio = habitacionesXtemporada.get(j).getPrecio();		//Obtengo el precio 
							factura.agregarItem(2, temporada2.getNombre(), cantidadDiasTemporada2, precio);
							j = habitacionesXtemporada.size(); //Corto el "for" para no recorrer de más
						}
					}
				}
			}							
			//Una vez haya agregado los items de la factura... 
			factura.setTotal(); //Le calculo el total. No lo calculaba antes porque mandar itemsFactura en el constructor seria complicado...
			//Entonces, ahora que si ya tiene los items, calculo el total. //Esto es todo interno. No se ve. 
			//Hasta acá se calcula el costo base de la estadia. 
			//Probemos agregar esta factura a la cuenta corriente del cliente
			estadia.getCliente().getCuentaCorriente().add(factura);	
	}							

} // end_class_EstadiaABM