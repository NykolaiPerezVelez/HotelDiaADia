package dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.ParteReparacion;


public class ParteReparacionDao {
	
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
	
	public int agregar(ParteReparacion objeto) {		
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

	
	public void actualizar(ParteReparacion objeto) throws HibernateException {
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
	
	
	public void eliminar(ParteReparacion objeto) throws HibernateException {
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
	
	
	public ParteReparacion traerParteReparacion(long idParteReparacion) throws HibernateException {
		ParteReparacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (ParteReparacion) session.get(ParteReparacion.class, idParteReparacion);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en ClienteABM. No estan en el codigo original del enunciado.  	
		} finally {
			session.close();
		}
		return objeto;
	}
	

	
	
	@SuppressWarnings("unchecked")
	public List<ParteReparacion> traerParteReparacion() throws HibernateException {
		List<ParteReparacion> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from ParteReparacion c order by c.idParteReparacion asc c.desperfecto asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	
	

}
