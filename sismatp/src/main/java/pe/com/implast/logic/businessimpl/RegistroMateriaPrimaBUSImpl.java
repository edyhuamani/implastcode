package pe.com.implast.logic.businessimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.RegistroMateriaPrimaBUS;
import pe.com.implast.model.dao.RegistraMateriaPrimaDAO;

@Service
public class RegistroMateriaPrimaBUSImpl implements RegistroMateriaPrimaBUS{
	
	@Autowired
	private RegistraMateriaPrimaDAO registraMateriaPrimaDAO;

	private static final Logger LOG=Logger.getLogger(RegistroMateriaPrimaBUS.class);	
	
	public void adicionarMateriaPrima() {
		
		try{
			registraMateriaPrimaDAO.registrarIngresoMateriaPrima();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	

}
