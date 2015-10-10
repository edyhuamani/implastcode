package pe.com.implast.model.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.ParteExtrusionBean;
import pe.com.implast.model.dao.ParteExtrusionDAO;

@Repository
public class ParteExtrusionDAOImpl implements ParteExtrusionDAO{
	
	private static final Logger LOG=Logger.getLogger(ParteExtrusionDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void registraParteExtrusion(ParteExtrusionBean parteExtrusion) {
		
		try{
		
		//jdbcTemplate.getDataSource();
		//jdbcTemplate.batchUpdate(sql, pss);
		
		
		} catch (Exception e){
			LOG.error(e);
		}
	}

	public void actualizaParteExtrusion(ParteExtrusionBean parteExtrusion) {
		try {
			
		}catch(Exception e){
			LOG.error(e);
		}
		
	}

	public void eliminaParteExtrusion(ParteExtrusionBean parteExtrusion) {
		try {
			
		}catch (Exception e){
			LOG.error(e);
		}
		
	}

	

}
