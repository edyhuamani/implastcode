package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.beans.MaquinaBean;

public interface MaquinaBUS {
	
	public void crearMaquina(MaquinaBean maquina);

	public ClienteBean obtenerMaquina(int idMaquina);

	public void actualizarMaquina(MaquinaBean maquina);

	public void eliminarMaquina(int idMaquina);	
	
	public List<MaquinaBean> listarMaquinasPaginado(Integer pagina, Integer registros);

	public List<MaquinaBean> obtenerListaMaquinas();
	
	public Integer totalMaquinas();
	
}
