package pe.com.implast.model.generic.dao;

public interface GenericDAO<T,E> {
	
	public void insertar(T t);
	
	public T obtener(String id);
	
	public void actualizar(T t);
	
	public void eliminar(String id);
}


