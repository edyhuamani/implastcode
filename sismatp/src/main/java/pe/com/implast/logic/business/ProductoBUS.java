package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.ProductoBean;

public interface ProductoBUS {
	
	void crearProducto(ProductoBean producto);

	ProductoBean obtenerCliente(int idProducto);

	void actualizarProducto(ProductoBean producto);

	void eliminarProducto(int idProducto);

	List<ProductoBean> listarProductos();

	List<ProductoBean> listarProductosPaginado(Integer pagina, Integer registros);

	Integer totalProductos();
	
}
