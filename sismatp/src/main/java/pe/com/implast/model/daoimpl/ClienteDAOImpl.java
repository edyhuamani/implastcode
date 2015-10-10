package pe.com.implast.model.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.dao.ClienteDAO;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	private static final Logger LOG=Logger.getLogger(ClienteDAOImpl.class);		
	
	public void crearCliente(ClienteBean cliente) {
		try{
			
		}catch(Exception e){
			LOG.error(e);
		}
	}

	public ClienteBean obtenerCliente(int idCliente) {
		try{
			
		} catch(Exception e){
			LOG.error(e);
		}
		return null;
	}

	public void actualizarCliente(ClienteBean cliente) {
		try{
			
		}catch (Exception e){
			LOG.error(e);
		}
	}

	public void eliminarCliente(int idCliente) {
		try{
			
		} catch (Exception e){
			LOG.error(e);
		}
	}
	
	
	
	
}
