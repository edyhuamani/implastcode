package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.ProductoBean;
import pe.com.implast.model.dao.ProductoDAO;

@Repository
public class ProductoDAOImpl implements ProductoDAO{

	private static final Logger LOG=Logger.getLogger(ProductoDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertar(ProductoBean t) {
		try{
			SimpleJdbcInsert simpleJdbc=new SimpleJdbcInsert(jdbcTemplate.getDataSource());
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	public ProductoBean obtener(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizar(ProductoBean t) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<ProductoBean> listarBeans() {
		List<ProductoBean> productos=null;
		String sql="select * from productos";
		try{
			productos=jdbcTemplate.query(sql, new RowMapper<ProductoBean>(){

				public ProductoBean mapRow(ResultSet result, int rownum)
						throws SQLException {
					
					return null;
				}
				
			});
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		return productos;
	}

	

}
