package pe.com.implast.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.com.implast.beans.ResponseObjectBean;
import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;

@Controller
public class RegistroIngresoMateriaPrimaController {
		
	private static final Logger LOG=Logger.getLogger(RegistroIngresoMateriaPrimaController.class);
	
	@Autowired
	MateriaPrimaBUS materiaPrimaBUS;
	
	@RequestMapping(value="/procesos/ingresoMateriaPrima.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		List<MateriaPrimaBean> materiasPrimas=null; 
		try{
			String viewName="ingresoMateriaPrima";
			materiasPrimas=materiaPrimaBUS.listarMaterias();
			response.addObject("materiasPrimas", materiasPrimas);
			response.setViewName(viewName);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
	
	
	//adicionarMateriaPrima.jon
	
	@RequestMapping(value="/procesos/adicionarMateriaPrima.json",method={RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseObjectBean<String> adicionarMateriaPrima(
			@RequestParam() String codigoMateriaPrima,
			@RequestParam() String codigo
			){
		ResponseObjectBean<String> response=new ResponseObjectBean<String>(); 
		try{
			
		}catch (Exception e){
			LOG.error(e.getMessage()  , e);
		}
		return response;
	}
	
}
