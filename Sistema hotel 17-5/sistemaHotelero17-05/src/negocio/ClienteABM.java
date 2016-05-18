package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER CLIENTE ///////////////////////////////////////////////////////////////////////

	public Cliente traerCliente(long idCliente) throws Exception {
		
		Cliente c = dao.traerCliente(idCliente);
		
		if (c == null) {
			throw new Exception("El cliente con ese id no existe");
		} // end_if
		else {
			return c;
		} // end_else
		
		// IMPLEMENTAR SI C ES NULL LANZAR EXCEPTION
		// SI TRAE 1 NO EXISTE EL ID
		
	} // end_public_traerCliente
	
	// METODO TRAER CLIENTE SOBRECARGADO //////////////////////////////////////////////////////////

	public Cliente traerCliente(int dni) throws Exception {
		
		Cliente c = dao.traerCliente(dni);
		
		if (c == null) {
			throw new Exception("MENSAJE: EL DNI ingresado no corresponde a un cliente");
		} // end_if
		else {
			return c;
		} // end_else
	} // end_public_traerCliente
	
	// METODO TRAER LISTA DE CLIENTES /////////////////////////////////////////////////////////////
	
	public List<Cliente> traerClientes() {
		return dao.traerClientes();
	} // end_traerClientes
	
	// METODO AGREGAR CLIENTE /////////////////////////////////////////////////////////////////////

	public int agregar(String apellido, String nombre, int dni, String telefono) throws Exception {

		Cliente c1 = dao.traerCliente(dni);
		Cliente c = null;

		if (c1 != null) {
			throw new Exception("MENSAJE: El DNI ingresado pertenece a un cliente existente");
		} // end_if
		else {
			c = new Cliente(apellido, nombre, dni, telefono);
		} // end_else
		
		return dao.agregar(c);
		
	} // end_public_agregar

	// METODO MODIFICAR CLIENTE ///////////////////////////////////////////////////////////////////

	public void modificar(Cliente c) throws Exception {

		Cliente c1 = dao.traerCliente(c.getDni());
		
		if (c1 != null) {
			if (c1.getIdCliente() != c.getIdCliente()) {
				throw new Exception("MENSAJE: El DNI ingresado corresponde a un cliente existente");
			} // end_if
		} // end_if
		
		dao.actualizar(c);

		/*
		 * implementar antes de actualizar que no exista un cliente con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */

	} // end_public_modificar
	
	// METODO ELIMINAR CLIENTE ////////////////////////////////////////////////////////////////////

	public void eliminar(long idCliente) throws Exception {

		Cliente cliente = dao.traerCliente(idCliente);
		
		/*if(cliente == null)
			throw new Exception("El cliente a eliminar no existe");
		} // end_if */
	
		dao.eliminar(cliente);
		
	} // end_public_eliminar

} // end_class_ClienteABM