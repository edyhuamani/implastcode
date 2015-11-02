package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.ClienteBean;

public interface ClienteDAO {
	
	public void crearCliente(ClienteBean cliente);
	
	public ClienteBean obtenerCliente(int idCliente);			
	
	public void actualizarCliente(ClienteBean cliente);

	public void eliminarCliente(int idCliente);
	
	public List<ClienteBean> listarClientes();

}
