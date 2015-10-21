package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoController {
	
	private static final Logger LOG=Logger.getLogger(ProductoController.class);  
	
	@RequestMapping(value="/mantenimiento/producto.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response =new ModelAndView();
		String viewName="producto"; 
		try{
			response.setViewName(viewName);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
}
