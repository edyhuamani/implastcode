package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.implast.beans.ResponseList;
import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;

@Controller
public class MateriaPrimaController {
	
	
	@Autowired
	private MateriaPrimaBUS materiaPrimaBUS;
	
	private static final Logger LOG=Logger.getLogger(MateriaPrimaController.class); 
	
	@RequestMapping(value="/mantenimiento/materiaPrima.htm",method={RequestMethod.GET})
	public String init(){
		String viewName="";
		try{
			viewName="materiaPrima";
		}catch(Exception e){
			LOG.error(e);
		}
		return viewName;
	}
	
	
	@RequestMapping(value="/mantenimiento/registrarMateriaPrima.htm",method={RequestMethod.POST})
	@ResponseBody
	public ResponseList<MateriaPrimaBean> registrarMateriaPrima(
			@RequestParam(value="codigoMateriaPrima") String codigoMateriaPrima,
			@RequestParam(value="descripción" ) String descripcion
			){
		ResponseList<MateriaPrimaBean> response=new ResponseList<MateriaPrimaBean>();
		try{
			MateriaPrimaBean mp=new MateriaPrimaBean();
			mp.setCodigoProveedor(codigoMateriaPrima);
			mp.setDescripcion(descripcion);
			materiaPrimaBUS.crearMateriaPrima(mp);
			
		}catch(Exception e){
			LOG.equals(e);
		}
		return response;
	}
}
