package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.ClienteBean;

public interface ClienteBUS {
	
	public void crearCliente(ClienteBean cliente);

	public ClienteBean obtenerCliente(int idCliente);

	public void actualizarCliente(ClienteBean cliente);

	public void eliminarCliente(int idCliente);	
	
	public List<ClienteBean> listarClientesPaginado(Integer pagina, Integer registros);

	public List<ClienteBean> obtenerListaClientes();
	
	public Integer totalClientes();

	
}
