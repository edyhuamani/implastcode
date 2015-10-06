package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistroIngresoMateriaPrimaController {
		
	private static final Logger LOG=Logger.getLogger(RegistroIngresoMateriaPrimaController.class);
	
	@RequestMapping(value="/procesos/ingresoMateriaPrima.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		
		try{
			String viewName="ingresoMateriaPrima";
			response.setViewName(viewName);
		}catch(Exception e){
			LOG.error(e);
		}
		return response;
	}
	
}
