package pe.com.implast.model.generic.dao;

public interface GenericDAO<T,E> {
	
	public void insertar(T t);
	
	public T get(String id);
	
	public void actualizar(T t);
	
	public void eliminar(String id);
}


