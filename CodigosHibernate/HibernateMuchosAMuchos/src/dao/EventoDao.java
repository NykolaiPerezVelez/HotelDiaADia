package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;	
import datos.Evento;


public class EventoDao {	
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
		
		public Evento traerEvento(long idEvento){
			Evento obj = null;
			try {	
				iniciaOperacion();
				String hQL="from Evento e where e.idEvento="+idEvento;
				obj = (Evento) session.createQuery(hQL).uniqueResult();
			} finally {
				session.close();
			}
			return obj;
		}		
		
		public Evento traerEventoYClientes(long idEvento) throws HibernateException {
			Evento obj = null;
			try {	
				iniciaOperacion();
				String hQL="from Evento e where e.idEvento="+idEvento;
				obj = (Evento) session.createQuery(hQL).uniqueResult();
				Hibernate.initialize(obj.getClientes());
			} finally {
				session.close();
			}
			return obj;
		}	
		
		
		public void actualizar(Evento objeto) throws HibernateException {
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
