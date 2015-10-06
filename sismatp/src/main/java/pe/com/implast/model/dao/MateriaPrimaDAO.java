package pe.com.implast.model.dao;

import pe.com.implast.model.beans.MateriaPrimaBean;

public interface MateriaPrimaDAO {
	
	void createMateriaPrima(MateriaPrimaBean mprima);

	MateriaPrimaBean retrieveMateriaPrima(int idMP);

	void updateMateriaPrima(MateriaPrimaBean mprima);

	void deleteMateriaPrima(int idMP);
}
