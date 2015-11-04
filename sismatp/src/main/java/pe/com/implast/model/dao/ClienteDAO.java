package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.ClienteBean;

public interface ClienteDAO {
	
	void crearCliente(ClienteBean cliente);

	ClienteBean obtenerCliente(int idCliente);

	void actualizarCliente(ClienteBean cliente);

	void eliminarCliente(int idCliente);

	List<ClienteBean> listarClientes();

	List<ClienteBean> listarClientesPaginado(Integer pagina,Integer registros);

	Integer totalClientes();

}
