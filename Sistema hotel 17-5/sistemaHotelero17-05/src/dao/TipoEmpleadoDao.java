package dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.TipoEmpleado;


public class TipoEmpleadoDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession(); //Crear una sesion 
		tx = session.beginTransaction(); //Crea una transaccion 
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();                                       
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}	
	
	public int agregar(TipoEmpleado objeto) {		
		int id = 0;
		try {
			iniciaOperacion(); //Crea la sesion y la transaccion 
			id = Integer.parseInt(session.save(objeto).toString()); //Agregamos el objeto 
			tx.commit(); //Y lo guardo tambien en la base de datos. 
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close(); //Cerramos la sesion 
		}
		return id;	
	}

	
	public void actualizar(TipoEmpleado objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();	
		}
	}	
	
	
	public void eliminar(TipoEmpleado objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto); 
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	
	public TipoEmpleado traerTipoEmpleado(long idTipoEmpleado) throws HibernateException {
		TipoEmpleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoEmpleado) session.get(TipoEmpleado.class, idTipoEmpleado);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en ClienteABM. No estan en el codigo original del enunciado.  	
		} finally {
			session.close();
		}
		return objeto;
	}
	

	
	
	@SuppressWarnings("unchecked")
	public List<TipoEmpleado> traerTipoEmpleado() throws HibernateException {
		List<TipoEmpleado> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from TipoEmpleado c order by c.idTipoEmpleado asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	

}
