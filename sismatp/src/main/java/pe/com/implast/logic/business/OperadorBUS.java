package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.OperadorBean;

public interface OperadorBUS {

	public void crearOperador(OperadorBean operador);

	public void obtenerOperador(int idOperador);

	public void actualizarOperador(OperadorBean operador);

	public void eliminarOperador(int idOperador);
	
	public List<OperadorBean> listarOperador();
	
	public List<OperadorBean> listarOperadorPaginado(Integer pagina, Integer registros);
	
	public Integer totalOperadores();

}
