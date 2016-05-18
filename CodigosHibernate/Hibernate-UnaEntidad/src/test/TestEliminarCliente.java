package test;

import negocio.ClienteABM;

public class TestEliminarCliente {									
	public static void main (String[] args){
		try{ //MOSTRAMOS SIMPLEMENTE QUE EL CLIENTE EXISTE. (si pongo todo junto en un TRY algunas cosas que quiero que se muestren, como la existencia del cliente, van a ser "invisibles" debido a la excepcion de traerCliente())
			ClienteABM abm = new ClienteABM();
			long id = 1;
			System.out.println("\nCliente a borrar en la base de datos: \n"+ abm.traerCliente(id)+"\n");		
		} 
		catch (Exception e){	
			System.out.println(e.getMessage());
		}
		try{ //ACA, UTILIZANDO EL MISMO ID, LO ELIMINAMOS.				
			ClienteABM abm = new ClienteABM();
			long id = 1;
			abm.eliminar(id);	 
			System.out.println("\nSi esto se muestra en pantalla quiere decir que el metodo eliminar no tuvo problemas (no hubo excepciones) y el cliente se eliminó\n");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}		
		try{ //INTENTAMOS MOSTRAR EL CLIENTE QUE NO EXISTE. (Aqui si se tendria que lanzar una excepcion)
			ClienteABM abm = new ClienteABM();
			long id = 1;
			abm.traerCliente(id);
		}
		catch (Exception e){	
			System.out.println(e.getMessage());	
		}	
	}
}
