package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.ProveedorBean;

public interface ProveedorDAO {

	void createProveedor(ProveedorBean mprima);

	ProveedorBean retrieveProveedor(int idProveedor);

	void updateProveedor(ProveedorBean mprima);

	void deleteProveedor(int idProveedor);
	
	public List<ProveedorBean> obtenerListaProveedores();
	
	public List<ProveedorBean> obtenerListaProveedoresPaginado(Integer Pagina,Integer registros);
	
	public Integer totalProveedores();
}
