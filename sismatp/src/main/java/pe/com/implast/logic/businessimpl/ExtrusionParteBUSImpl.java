package pe.com.implast.logic.businessimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ExtrusionParteBUS;
import pe.com.implast.model.beans.IngredienteBean;
import pe.com.implast.model.dao.ExtrusionParteDAO;

@Service
public class ExtrusionParteBUSImpl implements ExtrusionParteBUS {

	private static final Logger LOG=LoggerFactory.getLogger(ExtrusionParteBUSImpl.class);
	
	@Autowired
	ExtrusionParteDAO extrusionParteDAO;
	
	public void registraParteExtrusion() {
		
	}

	public List<IngredienteBean> seleccionarMezcla(String codigoProducto) {
		List<IngredienteBean> ingredientes=null;
		try{
			ingredientes=extrusionParteDAO.seleccionarMezcla(codigoProducto);
		} catch(Exception e ){
			LOG.error(e.getMessage(), e);
		}
		return ingredientes;
	}


}
