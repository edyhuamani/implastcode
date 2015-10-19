package pe.com.implast.logic.businessimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.OperadorBUS;
import pe.com.implast.model.beans.OperadorBean;
import pe.com.implast.model.dao.OperadorDAO;

@Service
public class OperadorBUSImpl implements OperadorBUS{

	private static final Logger LOG=Logger.getLogger(OperadorBUSImpl.class);
	
	@Autowired
	OperadorDAO operadorDAO;
	
	public void crearOperador(OperadorBean operador) {
		try{
			operadorDAO.createOperador(operador);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		
	}

	public void obtenerOperador(int idOperador) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarOperador(OperadorBean operador) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarOperador(int idOperador) {
		// TODO Auto-generated method stub
		
	}

	public List<OperadorBean> listarOperador(Integer pagina, Integer registros) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer totalOperadores() {
		Integer response=null;
		try{
			response=operadorDAO.totalOperadores();
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}

	public List<OperadorBean> listarOperador() {
		List<OperadorBean> operadores=null;
		try{
			operadores=operadorDAO.obtenerListaOperador();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return operadores;
	}

	public List<OperadorBean> listarOperadorPaginado(Integer pagina,
			Integer registros) {
		List<OperadorBean> operadores=null;	
		try{
			operadores=operadorDAO.obtenerListaOperadorPaginado(pagina, registros);

		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return operadores;
	}

}
