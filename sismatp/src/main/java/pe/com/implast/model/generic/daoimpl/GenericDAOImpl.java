package pe.com.implast.model.generic.daoimpl;

import org.apache.log4j.Logger;

import pe.com.implast.model.generic.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	private static final Logger LOG=Logger.getLogger(GenericDAOImpl.class);
	
	public void insertar(T t) {
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	public T get(String id) {
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

}
