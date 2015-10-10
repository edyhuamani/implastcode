package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.beans.ResponseObjectBean;
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
	
	
	@RequestMapping(value="/mantenimiento/registrarMateriaPrima.htm",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseObjectBean<String> registrarMateriaPrima(
			@RequestParam(value="codigoMateriaPrima") String codigoMateriaPrima,
			@RequestParam(value="descripción" ) String descripcion
			){
		ResponseObjectBean<String> response=new ResponseObjectBean<String>();
		try{
			MateriaPrimaBean mp=new MateriaPrimaBean();
			mp.setCodigoProveedor(codigoMateriaPrima);
			mp.setDescripcion(descripcion);
			materiaPrimaBUS.crearMateriaPrima(mp);
			//response.setRows(rows);
		}catch(Exception e){
			LOG.equals(e);
		}
		return response;
	}
}
