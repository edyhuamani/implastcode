package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.MaquinaBean;
import pe.com.implast.model.dao.MaquinaDAO;


@Repository
public class MaquinaDAOImpl implements MaquinaDAO{
	
	private static final Logger LOG=Logger.getLogger(MaquinaDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertar(MaquinaBean t) {
		
		try{
			
		}catch(Exception e){
			
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

	public List<MaquinaBean> listarBeans() {
		List<MaquinaBean> maquinas=null;
		
		String sql="select * from maquinas";
		try{
			maquinas=jdbcTemplate.query(sql, new RowMapper<MaquinaBean>(){
				public MaquinaBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						MaquinaBean maquina=new MaquinaBean();
						maquina.setCodigoMaquina(result.getString("codigo_maquina"));
						maquina.setDescMaquina(result.getString("descrip_maquina"));
					return maquina;
				}
			});
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		return maquinas;
	}

}
