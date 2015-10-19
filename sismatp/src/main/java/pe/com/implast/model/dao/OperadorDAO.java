package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.OperadorBean;


public interface OperadorDAO {
	
	void createOperador(OperadorBean operador);

	OperadorBean retrieveOperador(int idOperador);

	void updateOperador(OperadorBean mprima);

	void deleteOperador(int idOperador);
	
	public List<OperadorBean> obtenerListaOperador();
	
	public List<OperadorBean> obtenerListaOperadorPaginado(Integer pagina,Integer registros);
	
	public Integer totalOperadores();
}
