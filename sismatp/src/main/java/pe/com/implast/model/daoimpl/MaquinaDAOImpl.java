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

import pe.com.implast.model.beans.MaquinaBean;
import pe.com.implast.model.dao.MaquinaDAO;

@Repository
public class MaquinaDAOImpl implements MaquinaDAO{
	
	private static final Logger LOG=Logger.getLogger(MaquinaDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertar(MaquinaBean maq) {
		try{
			SimpleJdbcInsert simpleJdbc=new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("maquina").usingGeneratedKeyColumns("id_maq");
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("cod_maq", maq.getCodigoMaquina());
			params.put("desc_maq", maq.getDescMaquina());
			simpleJdbc.compile();
			simpleJdbc.execute(params);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		
	}

	public MaquinaBean obtener(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizar(MaquinaBean t) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<MaquinaBean> listar() {
		List<MaquinaBean> maquinas=null;
		
		String sql="Select cod_maq,desc_maq from Maquina";
		try{
			maquinas=jdbcTemplate.query(sql, new RowMapper<MaquinaBean>(){
				public MaquinaBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						MaquinaBean maquina=new MaquinaBean();
						maquina.setCodigoMaquina(result.getString("cod_maq"));
						maquina.setDescMaquina(result.getString("desc_maq"));
					return maquina;
				}
			});
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		return maquinas;
	}

	public List<MaquinaBean> listarMaquinaPaginado(Integer pagina,
			Integer registros) {

		List<MaquinaBean> maquinas=null;
		String sql="Select cod_maq,desc_maq from Maquina LIMIT 10 OFFSET ?";
		
		Integer inicioPagina=null;
		pagina=pagina-1;
		if (pagina==0){
			inicioPagina=0;
		}else {
			inicioPagina=pagina*registros;
		}
		
		try{
				maquinas=jdbcTemplate.query(sql, new Object[]{inicioPagina}, new RowMapper<MaquinaBean>(){
				public MaquinaBean mapRow(ResultSet result, int rownum)
						throws SQLException {
					MaquinaBean maquina=new MaquinaBean();
					maquina.setCodigoMaquina(result.getString("cod_maq"));
					maquina.setDescMaquina(result.getString("desc_maq"));
					return maquina;
				}
			});
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return maquinas;
	}

	public Integer totalMaquinas() {
		Integer cantidadProductos=null;
		String sql="";
		try{
			cantidadProductos=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return cantidadProductos;
	}

}
