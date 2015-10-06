package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuPrincipalController {
	
	private static final Logger LOG=Logger.getLogger(MenuPrincipalController.class);
	
	@RequestMapping(value="menu-principal.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		
		ModelAndView model=new ModelAndView();
		try{
			model.setViewName("menuPrincipal");
		}catch(Exception e){
			LOG.error("error on init() ", e);
		}
		return model;
	}
}
