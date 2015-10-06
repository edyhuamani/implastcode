package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultaMateriaPrimaSalidas {
	
	private static final Logger LOG=Logger.getLogger(ConsultaMateriaPrimaSalidas.class);
	
	@RequestMapping(value="/consultas/consultaSalidas.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView modelView=new ModelAndView();
		try{
			modelView.setViewName("consultaSalidas");
		}catch(Exception e){
			LOG.error(e);
		}
		return modelView;
	}
}
