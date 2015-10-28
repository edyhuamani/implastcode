package pe.com.implast.model.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.dao.RegSalidaExtrusionDAO;

@Repository
public class RegSalidaExtrusionDAOImpl implements RegSalidaExtrusionDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void registraSalidaExtrusion(){
		
	}

	
}
