package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.implast.model.beans.ProveedorBean;
import pe.com.implast.model.dao.ProveedorDAO;

@Repository
public class ProveedorDAOImpl  implements ProveedorDAO {

	private static final Logger LOG=Logger.getLogger(ProveedorDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void createProveedor(ProveedorBean proveedor) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(proveedor);
		}catch (HibernateException he){
			LOG.error(he.getMessage(),he);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
	}

	@Transactional
	public ProveedorBean retrieveProveedor(int idProveedor) {
		ProveedorBean proveedo=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			proveedo=(ProveedorBean) session.get(ProveedorBean.class, idProveedor);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		return proveedo;
	}

	public void updateProveedor(ProveedorBean proveedo) {
		try{	
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			ProveedorBean proveedor=(ProveedorBean) session.get(ProveedorBean.class, proveedo.getIdProveedor());
			proveedo.setRazonSocial(proveedor.getRazonSocial());
			session.update(proveedor);
			session.getTransaction().commit();
			session.close();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}	
	}

	public void deleteProveedor(int idProveedor) {
		try{	
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			ProveedorBean proveedor=(ProveedorBean) session.get(ProveedorBean.class, idProveedor);
			session.delete(proveedor);
			session.getTransaction().commit();
			session.close();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}	
	}
	
	@Transactional
	public List<ProveedorBean> obtenerListaProveedores() {
		List<ProveedorBean> proveedores=new ArrayList<ProveedorBean>();
		try{
			Session session=sessionFactory.getCurrentSession();
			proveedores=session.createCriteria(ProveedorBean.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return proveedores;
	}

	public Integer totalProveedores() {
		Integer response=null;
		try{
			String sql="Select count(*) from Proveedor";
			response=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}

	public List<ProveedorBean> obtenerListaProveedoresPaginado(Integer pagina,Integer registros) {
		List<ProveedorBean> proveedores=null;
		Integer inicioPagina=0;
		if (pagina.intValue()==1){
			pagina=pagina-1;
			inicioPagina=pagina;
		}else{
			pagina-=1;
			inicioPagina=pagina*registros;
		}
				
		String sql="SELECT COD_PRV,RAZ_SOC_PRV FROM PROVEEDOR LIMIT 10 OFFSET ?";
		try{
			proveedores=jdbcTemplate.query(sql,new Object[]{inicioPagina}, new RowMapper<ProveedorBean>(){

				public ProveedorBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						ProveedorBean proveedor=new ProveedorBean();
						proveedor.setCodigoProveedor(result.getString("COD_PRV"));
						proveedor.setRazonSocial(result.getString("RAZ_SOC_PRV"));
			
						return proveedor;
				}
				
			});
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return proveedores;
	}

}
