package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public MateriaPrimaBean retrieveMateriaPrima(String idMP) {
		
		MateriaPrimaBean materiaPrima=null;
		String sql="Select COD_MATP,DESC_MATP,COD_PRV from Materiaprima where cod_matp=?";
		try {
				materiaPrima=jdbcTemplate.queryForObject(sql, new Object[] {idMP},new RowMapper<MateriaPrimaBean>(){

				public MateriaPrimaBean mapRow(ResultSet result, int rownum)
						throws SQLException {
					MateriaPrimaBean materiaPrima=new MateriaPrimaBean();
					materiaPrima.setCodigoMateriaPrima(result.getString("COD_MATP"));
					materiaPrima.setDescMateriaPrima(result.getString("DESC_MATP"));
					materiaPrima.setCodigoProveedor(result.getString("COD_PRV"));
					return materiaPrima;
				}
				
			});
		}catch (DataAccessException de){
			LOG.error(de.getMessage(),de);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}finally{
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
	public List<MateriaPrimaBean> listarMateriasPrimasPaginado(Integer pagina, Integer registros) {
		
		Integer inicioPagina=null;
		pagina=pagina-1;
		if (pagina==0){
			inicioPagina=0;
		}else {
			inicioPagina=pagina*registros;
		}
		
		List<MateriaPrimaBean> response=new ArrayList<MateriaPrimaBean>(); 
		try{
			
			String sql="Select * from Materiaprima LIMIT 10 OFFSET ?";
			
			response=jdbcTemplate.query(sql,new Object[]{inicioPagina}, new RowMapper<MateriaPrimaBean>(){
				public MateriaPrimaBean mapRow(ResultSet result, int rownum)	throws SQLException {
					MateriaPrimaBean materia=new MateriaPrimaBean();
					materia.setCodigoMateriaPrima(result.getString("COD_MATP"));
					materia.setDescMateriaPrima(result.getString("DESC_MATP"));
					materia.setCodigoProveedor(result.getString("COD_PRV"));
					return materia;
				}
			});
			
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

	public List<MateriaPrimaBean> listarMateriasPrimas() {
		List<MateriaPrimaBean> materiasPrimas=new ArrayList<MateriaPrimaBean>();
		String sql="SELECT COD_MATP,DESC_MATP,COD_PRV FROM MATERIAPRIMA ORDER BY DESC_MATP";
		try{
			materiasPrimas=jdbcTemplate.query(sql, new RowMapper<MateriaPrimaBean>(){
				public MateriaPrimaBean mapRow(ResultSet result, int numrow)
						throws SQLException {
							MateriaPrimaBean materia=new MateriaPrimaBean();
							materia.setCodigoMateriaPrima(result.getString("COD_MATP"));
							materia.setDescMateriaPrima(result.getString("DESC_MATP"));
							materia.setCodigoProveedor(result.getString("COD_PRV"));
							return materia;
				}
				
			});
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return materiasPrimas;
	}

}
