package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.MateriaPrimaBean;

public interface MateriaPrimaBUS {
	
	public void crearMateriaPrima(MateriaPrimaBean materiaPrima);

	public void obtenerMateriaPrima(int idMateriaPrima);

	public void actualizarMateriaPrima(MateriaPrimaBean materiaPrima);

	public void eliminarMateriaPrima(int idMateriaPrima);
	
	public List<MateriaPrimaBean> listarMaterias();
	
	public List<MateriaPrimaBean> listarMateriasPrimasPaginado(Integer pagina, Integer registros);
	
	public Integer totalMateriasPrimas();
}
