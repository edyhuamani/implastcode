package pe.com.implast.logic.businessimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ProveedorBUS;
import pe.com.implast.model.beans.ProveedorBean;
import pe.com.implast.model.dao.ProveedorDAO;

@Service
public class ProveedorBUSImpl implements ProveedorBUS{

	private static final Logger LOG=Logger.getLogger(ProveedorBUSImpl.class);
	
	@Autowired
	ProveedorDAO proveedorDAO;
	
	public void crearProveedor(ProveedorBean proveedo) {
		try{
			proveedorDAO.createProveedor(proveedo);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
	}

	public void obtenerProveedor(int idProveedo) {
		try{
			proveedorDAO.retrieveProveedor(idProveedo);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
	}

	public void actualizarProveedor(ProveedorBean proveedo) {
		try{
			proveedorDAO.updateProveedor(proveedo);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
	}

	public void eliminarProveedor(int idProveedo) {
		try{
			proveedorDAO.deleteProveedor(idProveedo);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}
	
	
	public List<ProveedorBean> obtenerListaProveedores(){

		List<ProveedorBean> proveedores=new ArrayList<ProveedorBean>();
		try{
			proveedores=proveedorDAO.obtenerListaProveedores();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return proveedores;
	}

	public List<ProveedorBean> listarProveedoresPaginado(Integer pagina,	Integer registros) {
		List<ProveedorBean> response=new ArrayList<ProveedorBean>();
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}

	public Integer totalProveedores() {
		Integer response=null;
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
}
