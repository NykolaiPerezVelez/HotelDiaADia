package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;
import negocio.ClienteABM;

public class ContactoABM {
	
	ContactoDao dao = new ContactoDao();
	ClienteABM abm = new ClienteABM();
	
	public int agregar(String email, String movil, String fijo, Cliente c) throws Exception {
		
			Contacto contacto = abm.traerCliente(c.getIdCliente()).getContacto();
			if (contacto != null){ 
				throw new Exception ("Este cliente ya tiene un contacto asignado");
			}	
			contacto = new Contacto(email, movil, fijo, c);
			return dao.agregar(contacto);						
	} 		
}
	