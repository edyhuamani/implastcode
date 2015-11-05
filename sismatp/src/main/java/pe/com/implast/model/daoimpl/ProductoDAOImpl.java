package pe.com.implast.model.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import pe.com.implast.model.beans.IngredienteBean;
import pe.com.implast.model.beans.ProductoBean;
import pe.com.implast.model.dao.ProductoDAO;

@Repository
public class ProductoDAOImpl implements ProductoDAO{

	private static final Logger LOG=Logger.getLogger(ProductoDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PlatformTransactionManager txManager;
	
	public void insertar(final ProductoBean producto) {

		TransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus status=txManager.getTransaction(def);

		try{
			
			String sql_insert_header="INSERT INTO PRODUCTO(ID_PROD,COD_PROD,DESC_PROD) VALUES(DEFAULT,?,?)";
			
			Object[]  args=new Object[]{producto.getCodigoProducto(),producto.getDescripcion()};
			
			String sql_insert_detail="INSERT INTO MEZCLA(ID_MEZ,COD_PROD,COD_MATP,PORC_MEZC,CANT_MEZC) VALUES(DEFAULT,?,?,?,?)";
			
			/** producto **/
			jdbcTemplate.update(sql_insert_header, args);
			
			
			/** mezcla **/
			jdbcTemplate.batchUpdate(sql_insert_detail,new BatchPreparedStatementSetter() {
				
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					
					IngredienteBean ingrediente=producto.getMezcla().getIngredientes().get(i);
					ps.setString(1, producto.getCodigoProducto());
					ps.setString(2, ingrediente.getMateriaPrima().getCodigoMateriaPrima());
					ps.setDouble(3, ingrediente.getPorcentaje());
					ps.setDouble(4, ingrediente.getCantidad());
				}
				
				public int getBatchSize() {
					return producto.getMezcla().getIngredientes().size();
				}
			});
			
			
			txManager.commit(status);
			
			
		}catch(DataAccessException de){
			txManager.rollback(status);
			LOG.error(de.getMessage(), de);
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
		String sql="select cod_prod,desc_prod from producto order by desc_prod";
		try{
			productos=jdbcTemplate.query(sql, new RowMapper<ProductoBean>(){
				public ProductoBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						ProductoBean producto=new ProductoBean();
						producto.setCodigoProducto(result.getString("COD_PROD"));
						producto.setDescripcion(result.getString("DESC_PROD"));
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
						producto.setCodigoProducto(result.getString("COD_PROD"));
						producto.setDescripcion(result.getString("DESC_PROD"));					
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
