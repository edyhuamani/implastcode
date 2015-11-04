package pe.com.implast.web.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.com.implast.beans.ResponseObjectBean;
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
import pe.com.implast.model.beans.ParteExtrusionBean;
import pe.com.implast.model.beans.ProductoBean;
import pe.com.implast.model.dao.ExtrusionParteDAO;

@Controller
public class ExtrusionParteController {
	
	private static final Logger LOG=Logger.getLogger(ExtrusionParteController.class); 
	
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
	
	@Autowired
	ExtrusionParteDAO extrusionParteDAO;
	
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
			response.addObject("clientes", clientes);
			response.setViewName(viewName);
		}catch(Exception e){
			LOG.error(e);
		}
		return response;
	}

	
	@RequestMapping(value="/procesos/registrarParteExtrusion.json",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseObjectBean<String> registroParteExtrusion(
		@RequestParam(value="ordenTrabajo")String ordenTrabajo,
		@RequestParam(value="fecOrdenTrabajo")String fecOrdenTrabajo,
		@RequestParam(value="fecEntrega") String fecEntrega,
		@RequestParam(value="codSap") String sap,
		@RequestParam(value="codMaquina")String codMaquina,
		@RequestParam(value="status") String status,
		@RequestParam(value="codCliente") String codCliente,
		@RequestParam(value="codProducto") String codProducto,
		@RequestParam(value="ancho") String ancho,
		@RequestParam(value="espesor") String espesor,
		@RequestParam(value="tratado") String tratado,
		@RequestParam(value="solapa") String solapa,
		@RequestParam(value="fuelle") String fuelle,
		@RequestParam(value="grMin") String grMin,
		@RequestParam(value="max") String max,
		@RequestParam(value="min") String min,
		@RequestParam(value="maxProd") String maxProd,
		@RequestParam(value="minProd") String minProd,
		@RequestParam(value="scrap") String scrap,
		@RequestParam(value="codTipoManga") String codTipoManga
		
		
			){
			ResponseObjectBean<String> response=new ResponseObjectBean<String>();
			try{
				ParteExtrusionBean extrusionParte=new ParteExtrusionBean();
				extrusionParte.setOrdenTrabajo(ordenTrabajo);
				extrusionParte.setFechaOT(fecOrdenTrabajo);
				extrusionParte.setFechaEntrega(fecEntrega);
				extrusionParte.setCodigoSap(sap);
				extrusionParte.setCodigoMaquina(codMaquina);
				extrusionParte.setStatus(status);
				extrusionParte.setCodigoCliente(codCliente);
				
				extrusionParteDAO.registraSalidaExtrusion(extrusionParte);
				
			}catch (Exception e){
				
			}
			return response;
	}
}
