package pe.com.implast.logic.business;

import pe.com.implast.model.beans.MateriaPrimaBean;

public interface MateriaPrimaBUS {
	public void crearMateriaPrima(MateriaPrimaBean materiaPrima);

	public void obtenerMateriaPrima(int idMateriaPrima);

	public void actualizarMateriaPrima(MateriaPrimaBean materiaPrima);

	public void eliminarMateriaPrima(int idMateriaPrima);
}
