package pe.com.implast.model.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.dao.MateriaPrimaDAO;

@Repository
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {

	private static final Logger LOG=Logger.getLogger(MateriaPrimaDAOImpl.class);  
	
	@Autowired
	SessionFactory sessionFactory; 
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Transactional
	public void createMateriaPrima(MateriaPrimaBean mprima) {
		
		Session session=sessionFactory.getCurrentSession();
		try{
			session.saveOrUpdate(mprima);
		}catch(HibernateException he){
			LOG.error(he.getMessage(),he);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}finally{
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
	
	@Transactional
	public List<MateriaPrimaBean> listarMateriasPrimas(Integer pagina, Integer registros) {
		
		Integer inicio = (pagina - 1) * registros + 1;
		Integer fin = inicio + registros - 1;
		
		List<MateriaPrimaBean> response=new ArrayList<MateriaPrimaBean>(); 
		try{
			Session session=sessionFactory.getCurrentSession();
			response=session.createCriteria(MateriaPrimaBean.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}

	public Integer totalMateriasPrimas() {
		Integer response=null;
		try{
			String sql="Select count(*) from MateriaPrima";
			response=jdbcTemplate.queryForObject(sql, Integer.class);
			
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}

}
