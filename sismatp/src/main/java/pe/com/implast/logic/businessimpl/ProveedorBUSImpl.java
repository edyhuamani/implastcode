package pe.com.implast.logic.businessimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ProveedorBUS;
import pe.com.implast.model.beans.ProveedorBean;
import pe.com.implast.model.dao.ProveedorDAO;

@Service
public class ProveedorBUSImpl implements ProveedorBUS{

	@Autowired
	ProveedorDAO proveedorDAO;
	
	public void crearProveedor(ProveedorBean proveedo) {
		// TODO Auto-generated method stub
	}

	public void obtenerProveedor(int idProveedo) {
		// TODO Auto-generated method stub
	}

	public void actualizarProveedor(ProveedorBean proveedo) {
		// TODO Auto-generated method stub
	}

	public void eliminarProveedor(int idProveedo) {
		// TODO Auto-generated method stub
	}
	
}
