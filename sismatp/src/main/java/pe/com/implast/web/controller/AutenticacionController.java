package pe.com.implast.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutenticacionController {
	
	private static final Logger LOG=Logger.getLogger(AutenticacionController.class);
	
	@RequestMapping(value="/login.htm",method={RequestMethod.GET})
	public String autentica(){
		String viewName=StringUtils.EMPTY;
		try{
			viewName="home";
		}catch (Exception e){
			LOG.error(e);
		}
		return viewName;
	}
}
