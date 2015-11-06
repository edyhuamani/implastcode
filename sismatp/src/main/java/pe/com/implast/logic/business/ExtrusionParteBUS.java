package pe.com.implast.logic.business;

import java.util.List;

import pe.com.implast.model.beans.IngredienteBean;

public interface ExtrusionParteBUS {
	 
	void registraParteExtrusion();

	List<IngredienteBean> seleccionarMezcla(String codigoProducto);
}
