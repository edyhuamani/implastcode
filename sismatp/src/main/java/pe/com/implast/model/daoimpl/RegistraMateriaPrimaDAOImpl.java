package pe.com.implast.model.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.dao.RegistraMateriaPrimaDAO;

@Repository
public class RegistraMateriaPrimaDAOImpl implements RegistraMateriaPrimaDAO{

	private static final Logger LOG=Logger.getLogger(RegistraMateriaPrimaDAOImpl.class);	
	
	public void registrarIngresoMateriaPrima() {
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		
	}
	
}
