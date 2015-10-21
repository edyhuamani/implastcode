package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
	
	private static final Logger LOG=Logger.getLogger(ClienteController.class);
	
	@RequestMapping(value="/mantenimiento/clientes.htm",method={})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		String viewName="cliente";
		try{
			response.setViewName(viewName);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
}
