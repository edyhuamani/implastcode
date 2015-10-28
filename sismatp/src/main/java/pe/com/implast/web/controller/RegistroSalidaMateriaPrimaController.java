package pe.com.implast.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.logic.business.OperadorBUS;
import pe.com.implast.model.beans.InformacionMateriaPrimaBean;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.OperadorBean;

@Controller
public class RegistroSalidaMateriaPrimaController {
	
	private static final Logger LOG=Logger.getLogger(RegistroSalidaMateriaPrimaController.class); 
	
	List<InformacionMateriaPrimaBean> registroSalidasMateriasPrimas;
	
	
	@Autowired
	MateriaPrimaBUS materiaPrimaBUS;
	
	@Autowired
	OperadorBUS operadorBUS;
	
	@RequestMapping(value="/procesos/salidaMateriaPrima.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		List<MateriaPrimaBean> materiasPrimas=null; 
		List<OperadorBean> operadores=null;
		try{
			String viewName="salidaMateriaPrima";
			materiasPrimas=materiaPrimaBUS.listarMaterias();
			operadores=operadorBUS.listarOperador();
			
			response.addObject("materiasPrimas", materiasPrimas);
			response.addObject("operadores", operadores);
			response.setViewName(viewName);
		}catch(Exception e){
			LOG.error(e);
		}
		return response;
	}

}
