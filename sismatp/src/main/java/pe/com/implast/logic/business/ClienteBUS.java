package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.beans.MaquinaBean;

public interface ClienteBUS {
	
	public void crearCliente(ClienteBean cliente);

	public ClienteBean obtenerCliente(int idCliente);

	public void actualizarCliente(ClienteBean cliente);

	public void eliminarCliente(int idCliente);	
	
	public List<MaquinaBean> listarClientesPaginado(Integer pagina, Integer registros);

	public List<MaquinaBean> obtenerListaClientes();
	
	public Integer totalClientes();

	
}
