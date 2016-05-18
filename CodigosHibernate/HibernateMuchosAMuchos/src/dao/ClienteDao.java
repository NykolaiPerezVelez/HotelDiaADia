package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;

public class ClienteDao {
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
	
	public Cliente traerClienteYEventos(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql="from Cliente c where c.idCliente =" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getEventos());
		} finally {
			session.close();
		}
		return objeto;
		}
	
	public Cliente traerCliente(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql="from Cliente c where c.idCliente =" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;	
		}
	
	public void actualizar(Cliente objeto) throws HibernateException {
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
}
