package pe.com.implast.model.dao;

import java.util.List;

import pe.com.implast.model.beans.IngredienteBean;
import pe.com.implast.model.beans.ParteExtrusionBean;

public interface ExtrusionParteDAO {

	void registraExtrusionParte(ParteExtrusionBean extrusionParte);

	List<IngredienteBean> seleccionarMezcla(String codigoProducto);
}
