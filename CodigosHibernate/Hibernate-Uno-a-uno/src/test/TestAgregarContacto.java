package test;

import dao.ClienteDao;
import datos.Cliente;
import negocio.ContactoABM;

	public class TestAgregarContacto {	
		public static void main(String[] args) throws Exception {
			
			try{
				ClienteDao daoCliente = new ClienteDao();
				ContactoABM abm = new ContactoABM();
				long idCliente=1;
				Cliente c= daoCliente.traerCliente(idCliente);
				System.out.println(c);
				abm.agregar("ajaramillo@unla.edu.ar","11-1111-1111","011-1111-1111", c);
			}
			catch (Exception e){	
				System.out.println(e.getMessage());
			}
		}	
	}	
			