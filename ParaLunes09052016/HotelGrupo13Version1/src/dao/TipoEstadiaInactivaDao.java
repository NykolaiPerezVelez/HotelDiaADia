package dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.TipoEstadiaInactiva;


public class TipoEstadiaInactivaDao {
	
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
	
	public int agregar(TipoEstadiaInactiva objeto) {		
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

	
	public void actualizar(TipoEstadiaInactiva objeto) throws HibernateException {
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
	
	
	public void eliminar(TipoEstadiaInactiva objeto) throws HibernateException {
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
	
	
	public TipoEstadiaInactiva traerTipoEstadiaInactiva(long idTipoEstadiaInactiva) throws HibernateException {
		TipoEstadiaInactiva objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoEstadiaInactiva) session.get(TipoEstadiaInactiva.class, idTipoEstadiaInactiva);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en ClienteABM. No estan en el codigo original del enunciado.  	
		} finally {
			session.close();
		}
		return objeto;
	}
	

	
	
	@SuppressWarnings("unchecked")
	public List<TipoEstadiaInactiva> traerTipoEstadiaInactiva() throws HibernateException {
		List<TipoEstadiaInactiva> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from TipoEstadiaInactiva c order by c.idTipoEstadiaInactiva asc c.nombreTipo asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	

}
