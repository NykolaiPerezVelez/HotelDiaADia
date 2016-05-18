package test;

import negocio.ClienteABM;
import datos.Cliente;
import datos.Prestamo;

public class TestTraerClienteYPrestamos {
	public static void main(String[] args) {		
		try{
			
			long idCliente= 17; 						
			ClienteABM cliAbm= new ClienteABM();	
			Cliente c= cliAbm.traerClienteYPrestamos(idCliente);
			System.out.println("\n---> Traer Cliente y Prestamos idCliente="+idCliente);
			System.out.println("\n"+c); 
			for (Prestamo p: c.getPrestamos()) System.out.println("\n"+p); 
			
	   } catch (Exception e) {			
		  System.out.println(e.getMessage()); 
	   }
	   try{		
		    System.out.println("\n\n");		
		    long idCliente= 18; //El cliente 18 no existe (por lo menos en este momento) en la base de datos. 
			ClienteABM cliAbm= new ClienteABM();	
			Cliente c= cliAbm.traerClienteYPrestamos(idCliente);
			System.out.println("\n---> Traer Cliente y Prestamos idCliente="+idCliente);
			System.out.println("\n"+c); 	
			for (Prestamo p: c.getPrestamos()) System.out.println("\n"+p); 
	   } 
	   
	   catch (Exception e){
		   System.out.println(e.getMessage());   		
	   }
	}	
}										