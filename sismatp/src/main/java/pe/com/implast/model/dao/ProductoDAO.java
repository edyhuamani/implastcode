package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.ProductoBean;
import pe.com.implast.model.generic.dao.GenericDAO;

public interface ProductoDAO extends GenericDAO<ProductoBean, String> {
	
	public List<ProductoBean> listarProductosPaginado(Integer pagina, Integer registros);
	
	public Integer totalProductos();
}
