package pe.com.implast.logic.business;

import pe.com.implast.model.beans.ClienteBean;

public interface ClienteBUS {
	
	public void crearCliente(ClienteBean cliente);

	public ClienteBean obtenerCliente(int idCliente);

	public void actualizarCliente(ClienteBean cliente);

	public void eliminarCliente(int idCliente);	
	
}
