package pe.com.implast.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.com.implast.logic.business.ClienteBUS;
import pe.com.implast.logic.business.MaquinaBUS;
import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.logic.business.OperadorBUS;
import pe.com.implast.logic.business.ProductoBUS;
import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.beans.InformacionMateriaPrimaBean;
import pe.com.implast.model.beans.MaquinaBean;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.OperadorBean;
import pe.com.implast.model.beans.ProductoBean;

@Controller
public class RegistroSalidaMateriaPrimaController {
	
	private static final Logger LOG=Logger.getLogger(RegistroSalidaMateriaPrimaController.class); 
	
	List<InformacionMateriaPrimaBean> registroSalidasMateriasPrimas;
	
	@Autowired
	MateriaPrimaBUS materiaPrimaBUS;
	
	@Autowired
	OperadorBUS operadorBUS;
	
	@Autowired
	MaquinaBUS maquinaBUS;
	
	@Autowired
	ProductoBUS productoBUS;
	
	@Autowired
	ClienteBUS clienteBUS;
	
	@RequestMapping(value="/procesos/salidaMateriaPrima.htm",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		List<MateriaPrimaBean> materiasPrimas=null; 
		List<OperadorBean> operadores=null;
		List<MaquinaBean> maquinas=null;
		List<ProductoBean> productos=null;
		List<ClienteBean> clientes=null;
		
		try{
			String viewName="salidaMateriaPrima";
			
			materiasPrimas=materiaPrimaBUS.listarMaterias();
			operadores=operadorBUS.listarOperador();
			maquinas=maquinaBUS.obtenerListaMaquinas();
			productos=productoBUS.listarProductos();
			clientes=clienteBUS.obtenerListaClientes();
			response.addObject("materiasPrimas", materiasPrimas);
			response.addObject("operadores", operadores);
			response.addObject("maquinas", maquinas);
			response.addObject("productos", productos);
			
			response.setViewName(viewName);
		}catch(Exception e){
			LOG.error(e);
		}
		return response;
	}

}
