package pe.com.implast.logic.businessimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ClienteBUS;
import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.dao.ClienteDAO;

@Service
public class ClienteBUSImpl implements ClienteBUS {

	private static final Logger LOG=Logger.getLogger(ClienteBUSImpl.class);
	
	@Autowired
	ClienteDAO clienteDAO;
	
	public void crearCliente(ClienteBean cliente) {
		
	}

	public ClienteBean obtenerCliente(int idCliente) {
		return null;
	}

	public void actualizarCliente(ClienteBean cliente) {
		
	}

	public void eliminarCliente(int idCliente) {
		
	}

	public List<ClienteBean> listarClientesPaginado(Integer pagina,
			Integer registros) {
		return null;
	}

	public List<ClienteBean> obtenerListaClientes() {
		List<ClienteBean> clientes=null;
		try{
			clientes=clienteDAO.listarClientes();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return clientes;
	}

	public Integer totalClientes() {
		try{
			
		}catch(Exception e){
			
		}
		return null;
	}

}
