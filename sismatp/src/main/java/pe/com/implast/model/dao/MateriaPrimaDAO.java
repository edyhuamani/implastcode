package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.MateriaPrimaBean;

public interface MateriaPrimaDAO {
	
	void createMateriaPrima(MateriaPrimaBean mprima);

	MateriaPrimaBean retrieveMateriaPrima(String idMP);

	void updateMateriaPrima(MateriaPrimaBean mprima);

	void deleteMateriaPrima(int idMP);
	
	List<MateriaPrimaBean> listarMateriasPrimasPaginado(Integer pagina, Integer registros);
	
	List<MateriaPrimaBean> listarMateriasPrimas();
	
	Integer totalMateriasPrimas();
}
