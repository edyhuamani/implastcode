package pe.com.implast.logic.businessimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ClienteBUS;
import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.beans.MaquinaBean;

@Service
public class ClienteBUSImpl implements ClienteBUS {

	public void crearCliente(ClienteBean cliente) {
		
	}

	public ClienteBean obtenerCliente(int idCliente) {
		return null;
	}

	public void actualizarCliente(ClienteBean cliente) {
		
	}

	public void eliminarCliente(int idCliente) {
		
	}

	public List<MaquinaBean> listarClientesPaginado(Integer pagina,
			Integer registros) {
		return null;
	}

	public List<MaquinaBean> obtenerListaClientes() {
		return null;
	}

	public Integer totalClientes() {

		return null;
	}

}
