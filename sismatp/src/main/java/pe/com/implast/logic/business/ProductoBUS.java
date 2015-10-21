package pe.com.implast.logic.business;

import pe.com.implast.model.beans.ProductoBean;

public interface ProductoBUS {
	
	public void crearProducto(ProductoBean producto);

	public ProductoBean obtenerCliente(int idProducto);

	public void actualizarProducto(ProductoBean producto);

	public void eliminarProducto(int idProducto);	
}
