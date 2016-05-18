package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
	// METODOS OBLIGATORIOS ///////////////////////////////////////////////////////////////////////

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	// METODO TRAER CLIENTE ///////////////////////////////////////////////////////////////////////
	
	public Cliente traerCliente(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return objeto;
	} // end_public_traerCliente
	
	// METODO TRAER CLIENTE SOBRECARGADO //////////////////////////////////////////////////////////

	public Cliente traerCliente(int dni) throws HibernateException {
		Cliente objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni =" + dni).uniqueResult();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return objeto;
	} // end_public_traerCliente
	
	// METODO TRAER LISTA DE CLIENTES /////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public List<Cliente> traerClientes() throws HibernateException{
		
		List<Cliente> lista = null;
		
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.apellido asc c.nombre asc").list();

		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return lista;
	} // end_public_traerClientes
	
	// METODO AGREGAR CLIENTE /////////////////////////////////////////////////////////////////////

	public int agregar(Cliente objeto){
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString()); // CAPTURA EL ULTIMO ID USADO
			tx.commit(); // VUELVE LA TRANSACCION HACIA ATRAS
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close(); 
			}
		return id;
	} // end_public_agregar

	public void actualizar(Cliente objeto) throws HibernateException { // PUEDE DEVOLVER BOOLEAN
		try{
			iniciaOperacion();
			session.update(objeto);    // update 
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	} // end_class_actualizar

	public void eliminar(Cliente objeto) throws HibernateException { // PUEDE DEVOLVER BOOLEAQN
		try {
			iniciaOperacion();
			session.delete(objeto); // BORRA FISICAMENTE
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	} // end_public_eliminar
	
} // end_class_ClienteDao