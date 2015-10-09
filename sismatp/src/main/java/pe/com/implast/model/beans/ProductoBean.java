package pe.com.implast.model.beans;

import java.io.Serializable;

public class ProductoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3354815773579956242L;
	
	private int idProducto;
	private String descripcion;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
