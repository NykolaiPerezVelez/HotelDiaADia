package test;

import negocio.PrestamoABM;

public class TestEliminarPrestamo {				
	public static void main (String[] args){
		try{ //Primero mostramos que el prestamo existe
			PrestamoABM prestamoABM = new PrestamoABM();
			long idPrestamo = 9;	
			System.out.println(prestamoABM.traerPrestamo(idPrestamo)); 
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		try{ //Borramos el mismo prestamo 
			PrestamoABM prestamoABM = new PrestamoABM();
			long idPrestamo = 9;
			prestamoABM.eliminar(idPrestamo);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		try{ //Intentamos mostrar el prestamo que no existe 	
			PrestamoABM prestamoABM = new PrestamoABM();	
			long idPrestamo = 9;
			System.out.println(prestamoABM.traerPrestamo(idPrestamo)); 		
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}			
	}
}
