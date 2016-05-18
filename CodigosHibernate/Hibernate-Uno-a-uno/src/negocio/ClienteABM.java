package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.ClienteDao;			
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao= new ClienteDao();
	
	public Cliente traerCliente(long idCliente) throws Exception{	
		Cliente c= dao.traerCliente(idCliente); 
		if (c == null){
			throw new Exception ("Cliente nulo");				
		}
		return c; 
		
	}
	
	public Cliente traerCliente(int dni) throws Exception{
		Cliente c= dao.traerCliente(dni);  
		if (c == null){ 
			throw new Exception ("Cliente nulo");			
		}
		return c;
	 
	} 
	
	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) throws Exception { 
		
		//Consultar si existe un cliente con el mismo dni, si existe arrojar la Excepcion:
		
			Cliente c = dao.traerCliente(dni);		
			if (c != null){
				throw new Exception ("Ya existe un cliente con este DNI");	
			}
			c= new Cliente(apellido, nombre, dni,fechaDeNacimiento);
			return dao.agregar(c); 
				
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
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el cliente no tenga dependencias*/ 
		
		// ¿SI LA BASE DE DATOS ESTA CONFIGURADA CON BORRADO EN CASCADA? BORRARIAS EL CLIENTE Y YA SE BORRARIA LO RELACIONADO A EL. 
		//¿Como podria borrar las dependencias en este caso? (Una posibilidad tal vez no tan agradable)
		
		/*Cliente c = dao.traerClienteYContacto(idCliente); //Traigo el cliente
		if (c == null){ //Primero pregunto si es nulo.
			throw new Exception ("El cliente es nulo");	
		}
		if (c.getContacto() == null){ //Pregunto si su atributo Contacto es nulo. 
			dao.eliminar(c); //Si lo es, solo eliminamos el cliente. En contacto no hay nada referido a el. 
		}
		if (c.getContacto() != null){ //Si no es nulo
			//Aqui podria, con otro objeto DAO (de tipo Contacto), borrar primero el contacto del cliente. -> daoContacto.eliminar(Contacto contacto);
			// y despues lo borraria a el.  -> daoCliente.eliminar(Cliente cliente);
			//Ahi se eliminarian los datos en ambas tablas. 
		}	*/
		//Implementar que si es null arroje una excepcion 	
		Cliente c= dao.traerCliente(idCliente); 
		dao.eliminar(c); 				
	}
	
	public List<Cliente> traerCliente(){
		return dao.traerCliente(); 
	} 
	
}