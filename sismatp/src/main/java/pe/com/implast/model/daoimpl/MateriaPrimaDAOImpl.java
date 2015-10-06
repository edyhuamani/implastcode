package pe.com.implast.model.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.dao.MateriaPrimaDAO;
import pe.com.implast.utils.HibernateUtil;

@Repository
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {

	@Autowired
	LocalSessionFactoryBean sessionFactory; 
	
	public void createMateriaPrima(MateriaPrimaBean mprima) {
		
		SessionFactory sessionFactory= HibernateUtil.getFactorySession();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Transaction tx=session.getTransaction();
		session.save(mprima);
		tx.commit();
		session.close();
		
	}

	public MateriaPrimaBean retrieveMateriaPrima(int idMP) {

		SessionFactory sessionFactory=HibernateUtil.getFactorySession();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Transaction tx=session.getTransaction();
		MateriaPrimaBean mp=(MateriaPrimaBean) session.get(MateriaPrimaBean.class, idMP);
		tx.commit();
		session.close();
		return mp;
	}

	public void updateMateriaPrima(MateriaPrimaBean mprima) {
		
		SessionFactory sessionFactory=HibernateUtil.getFactorySession();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Transaction tx=session.getTransaction();
		session.saveOrUpdate(mprima);
		tx.commit();
		session.close();
	}

	public void deleteMateriaPrima(int idMP) {

		SessionFactory sessionFactory=HibernateUtil.getFactorySession();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Transaction tx=session.getTransaction();
		MateriaPrimaBean mp=(MateriaPrimaBean) session.get(MateriaPrimaBean.class, idMP);
		session.delete(mp);
		tx.commit();
		session.close();
		
		
		
	}

}
