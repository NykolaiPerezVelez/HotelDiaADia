package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AdmHotel {
	
	
	private ArrayList<Estadia> estadias;
	private ArrayList<Temporada> temporadas;			
	private ArrayList<TipoHabitacionXTemporada> tipoHabitacionesXtemporada;
	
	//Nico
	private ArrayList<Empleado> empleados;
	private ArrayList<Login> logins;
	private ArrayList<Permiso> permisos;
	private ArrayList<Habitacion> habitaciones;
	
	
	public AdmHotel(){				
		 this.estadias= new ArrayList<Estadia>();			
		 this.temporadas = new ArrayList<Temporada>();			
		 this.tipoHabitacionesXtemporada = new ArrayList<TipoHabitacionXTemporada>();	
		 //Nico
		 this.empleados = new ArrayList<Empleado>();
		 this.logins = new ArrayList<Login>();
		 this.permisos = new ArrayList<Permiso>();
		 this.habitaciones = new ArrayList<Habitacion>();
	}
	
	
	//Nico, Adhiero xD
	
	//Estos metodos seguramente no tienen que ir acá. 	
	
	//Para crear estadia desde el hotel				 
	public void agregarEstadia(Cliente cliente, Login empleado, GregorianCalendar fechaCreacion, GregorianCalendar diaCheckIn, 
			GregorianCalendar diaCheckOut, int cantidadAdultos, int cantidadNinios, TipoHabitacion tipoHabitacion){
		
		estadias.add(new Estadia(cliente, empleado, fechaCreacion, diaCheckIn, diaCheckOut, cantidadAdultos, cantidadNinios, tipoHabitacion));
	}	
	
	//Para crear estadia desde web 	
	public void agregarEstadia(Cliente cliente, GregorianCalendar fechaCreacion, GregorianCalendar diaCheckIn, 
			GregorianCalendar diaCheckOut, int cantidadAdultos, int cantidadNinios, TipoHabitacion tipoHabitacion){
		
		estadias.add(new Estadia(cliente, fechaCreacion, diaCheckIn, diaCheckOut, cantidadAdultos, cantidadNinios, tipoHabitacion));
	}
	
	public Estadia traerEstadia(Cliente cliente){ //Es para el TEST nada más. Obviamente el cliente puede tener muchas más estadias 		
		//Podria buscar por cliente y por fecha de CheckIn para obtener un unico resultado. 
		int i = 0;	
		int indiceEncontrado = -1; 
		for (i = 0; i<estadias.size(); i++){
			if (estadias.get(i).getCliente().getDni() == cliente.getDni()){
				indiceEncontrado = i; 
				i = estadias.size();		
			}
		}
	
		return estadias.get(indiceEncontrado); 			
	}
	
	////////NICO/////////////
	
	//Para crear los Permisos desde el hotel				 
	public void agregarPermisos(String descripcion){
		
		permisos.add(new Permiso(descripcion));
	}	
	
	
	//Para crear los logins desde el hotel				 
	public void agregarLogin(String usuario, String clave, String palabraClave, Empleado empleado, Permiso permiso){
		
		logins.add(new Login(usuario, clave,palabraClave, empleado, permiso));
	}	
	
	//Para crear empleados desde el hotel				 
	public void agregarEmpleado(GregorianCalendar fechaIngreso, String apellido, String nombre, int dni, String telefono,TipoEmpleado tipoEmpleado){
		
		empleados.add(new Empleado(fechaIngreso, apellido,nombre, dni, telefono,tipoEmpleado));
	}	
	
	
	//Para crear habitaciones desde el hotel			 
	public void agregarHabitacion(TipoHabitacion tipoHabitacion){
		
		habitaciones.add(new Habitacion(tipoHabitacion));
	}
	
	
	//De todos los empleados traigo a las mucamas
	public ArrayList<Empleado> traerMucamas (){
		ArrayList<Empleado> lstMucamas = new ArrayList<Empleado>();
		
		for (Empleado e: empleados){
			if (e.getTipoEmpleado().getNombreTipo()=="Mucama"){ //Es mejor con un equals o un idTipo, pero por ahora anda asi
				lstMucamas.add(e); 
			}//Agrego solo mucamas
		}//cierro el for
		
	return lstMucamas;}//Cierra el metodo
	
	
	//Veo cual es la mucama que menos trabajo tiene 
	public Login traerMucamaMasDisponible(){
		Login loginMucamaAAsignar = new Login();
		ArrayList<Empleado> mucamas = new ArrayList<Empleado> ();
		mucamas = traerMucamas();
		float minimoTrabajo = 10000;
		
        for(Empleado m: mucamas){
        	if (m.getLogin().getCantHabAsignadas()<= minimoTrabajo){
        		minimoTrabajo = m.getLogin().getCantHabAsignadas();
             }//Cierro el if
        }//Cierro el for...... Ahora tengo el  minimo POSTA
        
        for(Empleado m: mucamas){
        	if (m.getLogin().getCantHabAsignadas()== minimoTrabajo){
        		loginMucamaAAsignar = m.getLogin();
        	}//Cierro el if
        }//Cierro el for
		
		
		return loginMucamaAAsignar; //Retorno la mucama mas vaga
	}//Cierro el metodo
	
	
	//Agrego mucama a una habitacion
	public void asignarMucamaAHabitacion (Habitacion h){
		h.setLogin(traerMucamaMasDisponible());
		//Le aumento la NO disponibilidad
		traerMucamaMasDisponible().setCantHabAsignadas(traerMucamaMasDisponible().getCantHabAsignadas()+1);
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////GETS Y SETS/////////////////////////////////////////////////////////
	
	public ArrayList<Estadia> getEstadias(){			
		return estadias;
	}
	
	public void setEstadias(ArrayList<Estadia> estadias){
		this.estadias = estadias; 	
	}

	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public ArrayList<TipoHabitacionXTemporada> getTipoHabitacionesXtemporada() {
		return tipoHabitacionesXtemporada;
	}

	public void setTipoHabitacionesXtemporada(ArrayList<TipoHabitacionXTemporada> tipoHabitacionesXtemporada) {
		this.tipoHabitacionesXtemporada = tipoHabitacionesXtemporada;
		
		
		
	}


	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}


	public ArrayList<Login> getLogins() {
		return logins;
	}


	public void setLogins(ArrayList<Login> logins) {
		this.logins = logins;
	}


	public ArrayList<Permiso> getPermisos() {
		return permisos;
	}


	public void setPermisos(ArrayList<Permiso> permisos) {
		this.permisos = permisos;
	}


	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}	
	
	
}
