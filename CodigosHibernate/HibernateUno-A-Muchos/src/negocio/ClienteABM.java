package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.ClienteDao;				
import datos.Cliente;

public class ClienteABM {				
	ClienteDao dao=new ClienteDao();
	
	public Cliente traerCliente(long idCliente) throws Exception{	
		Cliente c= dao.traerCliente(idCliente); 
		if (c == null){
			throw new Exception ("Cliente nulo");				
		}	
		return c; 
		
		/*¿Las excepciones no deben estar en ClienteDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el cliente asume que Hibernate puede traer un cliente = null cuando no encuentra un "id" en la base de datos.
		 */	
	}
	
	public Cliente traerCliente(int dni) throws Exception{
		Cliente c= dao.traerCliente(dni);  
		if (c == null){ 
			throw new Exception ("Cliente nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Cliente == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) throws Exception { 
		
		//Consultar si existe un cliente con el mismo dni, si existe arrojar la Excepcion:
		
			Cliente c = dao.traerCliente(dni);		
			if (c != null){
				throw new Exception ("Ya existe un cliente con este DNI");	
			}
			c= new Cliente(apellido, nombre, dni,fechaDeNacimiento);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Cliente c) throws Exception {
		// Implementar antes de actualizar que no exista un cliente con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Cliente d = dao.traerCliente(c.getDni());
		if (d != null){					
			if (d.getIdCliente() != c.getIdCliente()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un cliente con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);	
			
	}	
	
	public void eliminar(long idCliente) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso (lo comun es hacer bajas logicas). 
		 * Si se hiciera (la baja fisica), habría que validar que el cliente no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Cliente c= dao.traerCliente(idCliente); 
		if (c == null){
			throw new Exception ("El cliente es nulo");		
		}
		dao.eliminar(c);	 			
	}
	
	public List<Cliente> traerCliente(){
		return dao.traerCliente(); 		
	} 
	
	public Cliente traerClienteYPrestamos(long idCliente) throws Exception{	
		Cliente c = dao.traerClienteYPrestamos(idCliente);
		if (c.getPrestamos().isEmpty()) {	
			throw new Exception ("Este cliente no tiene prestamos"); 
		}																					  
		return c;																 
	}			
	
}
