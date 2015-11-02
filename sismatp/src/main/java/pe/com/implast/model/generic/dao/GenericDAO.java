package pe.com.implast.model.generic.dao;

import java.util.List;

public interface GenericDAO<T, E> {

	void insertar(T t);

	T obtener(String id);

	void actualizar(T t);

	void eliminar(String id);

	List<T> listar();
}

