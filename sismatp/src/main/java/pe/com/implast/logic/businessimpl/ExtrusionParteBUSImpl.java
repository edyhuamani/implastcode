package pe.com.implast.logic.businessimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.ExtrusionParteBUS;
import pe.com.implast.model.dao.ExtrusionParteDAO;

@Service
public class ExtrusionParteBUSImpl implements ExtrusionParteBUS {

	
	@Autowired
	ExtrusionParteDAO extrusionParteDAO;
	
	public void registraParteExtrusion() {
		
	}


}
