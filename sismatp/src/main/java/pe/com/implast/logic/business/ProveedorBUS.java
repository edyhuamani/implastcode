package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.ProveedorBean;

public interface ProveedorBUS {

	public void crearProveedor(ProveedorBean proveedo);

	public void obtenerProveedor(int idProveedo);

	public void actualizarProveedor(ProveedorBean proveedo);

	public void eliminarProveedor(int idProveedo);
	
	public List<ProveedorBean> listarProveedoresPaginado(Integer pagina, Integer registros);

	public List<ProveedorBean> obtenerListaProveedores();
	
	public Integer totalProveedores();
}
