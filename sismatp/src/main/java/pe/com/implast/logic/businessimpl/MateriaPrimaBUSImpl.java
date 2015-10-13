package pe.com.implast.logic.businessimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.dao.MateriaPrimaDAO;

@Service
public class MateriaPrimaBUSImpl implements MateriaPrimaBUS {

	private static final Logger LOG=Logger.getLogger(MateriaPrimaBUSImpl.class);
	
	@Autowired
	MateriaPrimaDAO materiaPrimaDAO;
	
	public void crearMateriaPrima(MateriaPrimaBean materiaPrima) {
		try{
			materiaPrimaDAO.createMateriaPrima(materiaPrima);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		
	}

	public void obtenerMateriaPrima(int idMateriaPrima) {
		try{
			materiaPrimaDAO.retrieveMateriaPrima(idMateriaPrima);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		
	}

	public void actualizarMateriaPrima(MateriaPrimaBean materiaPrima) {
		try{
			materiaPrimaDAO.createMateriaPrima(materiaPrima);
		} catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		
	}

	public void eliminarMateriaPrima(int idMateriaPrima) {
		try{
			materiaPrimaDAO.deleteMateriaPrima(idMateriaPrima);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		
	}

}
