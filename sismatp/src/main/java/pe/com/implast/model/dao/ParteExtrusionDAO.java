package pe.com.implast.model.dao;

import pe.com.implast.model.beans.ParteExtrusionBean;

public interface ParteExtrusionDAO {
	
	void registraParteExtrusion(ParteExtrusionBean parteExtrusion);

	void actualizaParteExtrusion(ParteExtrusionBean parteExtrusion);

	void eliminaParteExtrusion(ParteExtrusionBean parteExtrusion);
	
}
