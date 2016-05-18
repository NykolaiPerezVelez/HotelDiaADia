package negocio;

import dao.PrestamoDao;
//import dao.CuotaDao;


import java.util.GregorianCalendar;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;
	
public class PrestamoABM {
	private PrestamoDao dao= new PrestamoDao();	
	
	public Prestamo traerPrestamo(long idPrestamo) throws Exception { //Implementar: si no existe el prestamo lanzar la excepci�n
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if (p == null){	
			throw new Exception ("El prestamo no existe");
		}
		return p;				
	}							
	
	public List<Prestamo> traerPrestamo(Cliente c) throws Exception {
		List<Prestamo> p = null; 
		p = dao.traerPrestamo(c);
		if (p.isEmpty()){
			throw new Exception ("No hay prestamos correspondientes a este Cliente");
		}
		return p;		
	}		
	
	public int agregar(GregorianCalendar fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception {
			Prestamo p = new Prestamo(fecha, monto, interes , cantCuotas, cliente);
			int j = dao.agregar(p);   
			return j;							 	
	}		
	
	public void modificar(Prestamo p) throws Exception {
		dao.actualizar(p);							
	}
	
	public void eliminar(long idPrestamo) throws Exception {
		
		/* En este caso es una baja f�sica. En gral, no se se aplicar�a este caso de uso. 
		 * Si se hiciera, habr�a que validar que el cliente no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Prestamo prestamo = dao.traerPrestamo(idPrestamo); 
		if (prestamo == null){
			throw new Exception ("El prestamo es nulo");		
		}
		dao.eliminar(prestamo); 			
	}
	
}