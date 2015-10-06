package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultaMateriaPrimaIngresos {

	private static final Logger LOG=Logger.getLogger(ConsultaMateriaPrimaIngresos.class);
	
	@RequestMapping(value="/consultas/consultaIngresos.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView modelView=new ModelAndView();
		try{
			modelView.setViewName("consultaIngresos");
		}catch(Exception e){
			LOG.error(e);
		}
		return modelView;
	}
}
