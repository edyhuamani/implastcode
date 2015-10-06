package pe.com.implast.logic.business;

import pe.com.implast.model.beans.ProveedorBean;

public interface ProveedorBUS {

	public void crearProveedor(ProveedorBean proveedo);

	public void obtenerProveedor(int idProveedo);

	public void actualizarProveedor(ProveedorBean proveedo);

	public void eliminarProveedor(int idProveedo);

}
