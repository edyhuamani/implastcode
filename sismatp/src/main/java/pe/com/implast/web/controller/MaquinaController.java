package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MaquinaController {
	
	private static final Logger LOG=Logger.getLogger(MaquinaController.class);
	
	@RequestMapping(value="/mantenimiento/maquinas.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		String viewName="maquina";
		try{
			response.setViewName(viewName);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
}
