package pe.com.implast.logic.businessimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ProductoBUS;
import pe.com.implast.model.beans.ProductoBean;
import pe.com.implast.model.dao.ProductoDAO;

@Service
public class ProductoBUSImpl implements ProductoBUS{
	
	private static final Logger LOG=Logger.getLogger(ProductoBUSImpl.class); 
	
	@Autowired
	ProductoDAO productoDAO;

	public void crearProducto(ProductoBean producto) {
		// TODO Auto-generated method stub
		
	}

	public ProductoBean obtenerCliente(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarProducto(ProductoBean producto) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub
		
	}

	public List<ProductoBean> listarProductos() {
		List<ProductoBean> productos=null;
		try{
			productos=productoDAO.listarBeans();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return productos;
	}

}
