package test;

import java.util.GregorianCalendar;

import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {
	public static void main (String[] args){
		try{
			PrestamoABM prestamoABM = new PrestamoABM();
			ClienteABM clienteABM = new ClienteABM();
			GregorianCalendar f1 = new GregorianCalendar(2016, 4, 4);
			prestamoABM.agregar(f1, 5000, 15, 8, clienteABM.traerCliente(35000000));
		}
		catch (Exception e){			
			System.out.println(e.getMessage());	
		}
	}
}	
