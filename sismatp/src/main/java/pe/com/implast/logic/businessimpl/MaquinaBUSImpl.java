package pe.com.implast.logic.businessimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.MaquinaBUS;
import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.beans.MaquinaBean;
import pe.com.implast.model.dao.MaquinaDAO;

@Service
public class MaquinaBUSImpl implements MaquinaBUS{

	private static final Logger LOG=Logger.getLogger(MaquinaBUSImpl.class);
	
	@Autowired
	MaquinaDAO maquinaDAO;
	
	public void crearMaquina(MaquinaBean maquina) {
		try{
			maquinaDAO.insertar(maquina);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
	}

	public ClienteBean obtenerMaquina(int idMaquina) {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarMaquina(MaquinaBean maquina) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarMaquina(int idMaquina) {
		// TODO Auto-generated method stub
		
	}

	public List<MaquinaBean> listarMaquinasPaginado(Integer pagina,
			Integer registros) {
		List<MaquinaBean> response=null;
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}

	public List<MaquinaBean> obtenerListaMaquinas() {
		List<MaquinaBean> response=null;
		try{
			response=maquinaDAO.listar();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}

	public Integer totalMaquinas() {
		// TODO Auto-generated method stub
		return null;
	}

}
