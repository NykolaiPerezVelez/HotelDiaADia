package dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cuota;


public class CuotaDao {	
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();				
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}	
	
	public int agregar(Cuota objeto) {		
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
	


	public void actualizar(Cuota objeto) throws HibernateException {
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
	
	public void eliminar(Cuota objeto) throws HibernateException {
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
	
	public Cuota traerCuota(long idCuota) throws HibernateException {
		Cuota objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cuota) session.get(Cuota.class, idCuota);		
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;*/  //Estos "catch" comentareados estan puestos en base a una duda explicada en CuotaABM. No estan en el codigo original del enunciado.  	
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Cuota traerCuota(int dni) throws HibernateException {	
		Cuota objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cuota) session.createQuery("from Cuota c where c.dni="+dni).uniqueResult();
		/*} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he; */	
		} finally {
			session.close(); 
		}	
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuota> traerCuota() throws HibernateException {
		List<Cuota> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Cuota c order by c.apellido asc c.nombre asc").list();
	} finally {
		session.close();
	}
	return lista;	
	}
	

		
}