package pe.com.implast.model.generic.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import pe.com.implast.model.generic.dao.GenericDAO;

public class GenericDAOImpl<T extends Serializable,E> implements GenericDAO<T,E> {

	private static final Logger LOG=Logger.getLogger(GenericDAOImpl.class);
	
	public void insertar(T t) {
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	public T obtener(String id) {
		T t=null;
		
		try{
			
		} catch (Exception e){
			LOG.error(e.getMessage(), e);
		} 
		return t;
	}

	public void actualizar(T t) {
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	public void eliminar(String id) {
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	public List<T> listarBeans() {
		// TODO Auto-generated method stub
		return null;
	}

}
