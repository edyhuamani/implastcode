package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.MateriaPrimaBean;
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
			Map<String,Object> params=new HashMap<String ,Object>();
			//params.put(key, value);
			//params.put(key, value);
			simpleJdbc.execute(params);
			
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

	public List<ProductoBean> listar() {
		List<ProductoBean> productos=null;
		String sql="select cod_prod,desc_prod from producto";
		try{
			productos=jdbcTemplate.query(sql, new RowMapper<ProductoBean>(){
				public ProductoBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						ProductoBean producto=new ProductoBean();
						producto.setCodigoProducto(result.getString("cod_prod"));
						producto.setDescripcion(result.getString("desc_prod"));
						return producto;
				}
			});
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		return productos;
	}

	public List<ProductoBean> listarProductosPaginado(Integer pagina,
			Integer registros) {
		List<ProductoBean> productos=null;
		String sql="select cod_prod,desc_prod  from producto LIMIT 10 OFFSET ? ";
		try{
			productos=jdbcTemplate.query(sql, new Object[]{}, new RowMapper<ProductoBean>(){

				public ProductoBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						ProductoBean producto=new ProductoBean();
						producto.setCodigoProducto(result.getString("cod_prod"));
						producto.setDescripcion(result.getString("desc_prod"));					
						return producto;
				}
			});
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return productos;
	}

	public Integer totalProductos() {
		Integer response=null;
		String sql="Select count(1) from Productos";
		try{
			response=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}


	

}
