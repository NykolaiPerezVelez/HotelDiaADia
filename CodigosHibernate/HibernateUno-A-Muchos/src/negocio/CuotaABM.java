package negocio;


import java.util.List;	
import dao.CuotaDao;				
import datos.Cuota;

public class CuotaABM {				
	CuotaDao dao=new CuotaDao();
	
	public Cuota traerCuota(long idCuota) throws Exception{	
		Cuota c= dao.traerCuota(idCuota); 
		if (c == null){
			throw new Exception ("Cuota nulo");				
		}	
		return c; 
		
		/*¿Las excepciones no deben estar en CuotaDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Cuota asume que Hibernate puede traer un Cuota = null cuando no encuentra un "id" en la base de datos.
		 */	
	}
	
	public Cuota traerCuota(int dni) throws Exception{
		Cuota c= dao.traerCuota(dni);  
		if (c == null){ 
			throw new Exception ("Cuota nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Cuota == null no deberia identificarse en la capa de acceso a datos? 
	} 
	

	
	public void modificar(Cuota c) throws Exception {
		// Implementar antes de actualizar que no exista un Cuota con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Cuota d = dao.traerCuota(c.getIdCuota());
		if (d != null){					
			if (d.getIdCuota() != c.getIdCuota()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Cuota con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);	
			
	}	
	
	public void eliminar(long idCuota) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso (lo comun es hacer bajas logicas). 
		 * Si se hiciera (la baja fisica), habría que validar que el Cuota no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Cuota c= dao.traerCuota(idCuota); 
		if (c == null){
			throw new Exception ("El Cuota es nulo");		
		}
		dao.eliminar(c);	 			
	}
	
	public List<Cuota> traerCuota(){
		return dao.traerCuota(); 		
	} 
	
			
	
}
