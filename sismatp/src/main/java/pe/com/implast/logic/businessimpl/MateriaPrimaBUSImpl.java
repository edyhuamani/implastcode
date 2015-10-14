package pe.com.implast.logic.businessimpl;

import java.util.ArrayList;
import java.util.List;

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

	public List<MateriaPrimaBean> listarMateriasPrimas(Integer pagina, Integer registros) {

		List<MateriaPrimaBean> materiasPrimas=new ArrayList<MateriaPrimaBean>();
		try{
			materiasPrimas=materiaPrimaDAO.listarMateriasPrimas(pagina,registros);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		return materiasPrimas;
	}

	public Integer totalMateriasPrimas() {
		Integer totalMateriasPrimas=null;
		try{
			totalMateriasPrimas=materiaPrimaDAO.totalMateriasPrimas();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return totalMateriasPrimas;
	}

}
