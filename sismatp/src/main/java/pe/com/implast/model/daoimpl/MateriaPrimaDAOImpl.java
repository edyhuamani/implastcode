package pe.com.implast.model.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.dao.MateriaPrimaDAO;

@Repository
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {

	private static final Logger LOG=Logger.getLogger(MateriaPrimaDAOImpl.class);  
	
	@Autowired
	SessionFactory sessionFactory; 
	
	@Transactional
	public void createMateriaPrima(MateriaPrimaBean mprima) {
		
		Session session=sessionFactory.getCurrentSession();

		try{
			//session.beginTransaction();
			session.saveOrUpdate(mprima);
			//session.getTransaction().commit();
		}catch(HibernateException he){
			//session.getTransaction().rollback();
			//LOG.error(he.getMessage(),he);
		}catch(Exception e){
			//session.getTransaction().rollback();
			LOG.error(e.getMessage(),e);
		}finally{
			//session.close();
		}	
	}

	@Transactional
	public MateriaPrimaBean retrieveMateriaPrima(int idMP) {
		
		MateriaPrimaBean materiaPrima=null;
		Session session=sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			materiaPrima=(MateriaPrimaBean) session.get(MateriaPrimaBean.class, idMP);
		}catch (HibernateException he){
			LOG.error(he.getMessage(),he);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}finally{
			session.close();
		}
		return materiaPrima;
	}

	public void updateMateriaPrima(MateriaPrimaBean mprima) {
		
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Transaction tx=session.getTransaction();
		session.saveOrUpdate(mprima);
		tx.commit();
		session.close();
	}

	public void deleteMateriaPrima(int idMP) {

		Session session=sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Transaction tx=session.getTransaction();
		MateriaPrimaBean mp=(MateriaPrimaBean) session.get(MateriaPrimaBean.class, idMP);
		session.delete(mp);
		tx.commit();
		session.close();
		
		
		
	}

}
