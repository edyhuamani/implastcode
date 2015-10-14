package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OperadorController {
	
	private static final Logger LOG=Logger.getLogger(OperadorController.class); 
	
	@RequestMapping(value="/mantenimiento/operador.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView model=new ModelAndView();
		try{
			String viewName="operador";
			model.setViewName(viewName);;
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return model;
	}
}
