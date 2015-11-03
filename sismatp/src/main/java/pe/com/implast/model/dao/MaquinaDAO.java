package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.MaquinaBean;
import pe.com.implast.model.generic.dao.GenericDAO;

public interface MaquinaDAO extends GenericDAO<MaquinaBean, String>{
	
	public List<MaquinaBean> listarMaquinaPaginado(Integer pagina, Integer registros);
	
	public Integer totalMaquinas();
}
