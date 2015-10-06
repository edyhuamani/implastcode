package pe.com.implast.model.dao;

import pe.com.implast.model.beans.ProveedorBean;

public interface ProveedorDAO {

	void createProveedor(ProveedorBean mprima);

	ProveedorBean retrieveProveedor(int idProveedor);

	void updateProveedor(ProveedorBean mprima);

	void deleteProveedor(int idProveedor);
}
