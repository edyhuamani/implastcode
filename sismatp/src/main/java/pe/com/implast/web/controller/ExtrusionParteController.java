package pe.com.implast.web.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
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
			String viewName="parteExtrusionCabecera";
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
		@RequestParam(value="ordenTrabajo",defaultValue=StringUtils.EMPTY)String ordenTrabajo,
		@RequestParam(value="fecOrdenTrabajo",defaultValue=StringUtils.EMPTY)String fecOrdenTrabajo,
		@RequestParam(value="fecEntrega",defaultValue=StringUtils.EMPTY) String fecEntrega,
		@RequestParam(value="codSap",defaultValue=StringUtils.EMPTY) String sap,
		@RequestParam(value="codMaquina",defaultValue=StringUtils.EMPTY)String codMaquina,
		@RequestParam(value="status",defaultValue=StringUtils.EMPTY) String status,
		@RequestParam(value="codCliente",defaultValue=StringUtils.EMPTY) String codCliente,
		@RequestParam(value="codProducto",defaultValue=StringUtils.EMPTY) String codProducto,
		@RequestParam(value="ancho",defaultValue=StringUtils.EMPTY) String ancho,
		@RequestParam(value="espesor",defaultValue=StringUtils.EMPTY) String espesor,
		@RequestParam(value="tratado",defaultValue=StringUtils.EMPTY) String tratado,
		@RequestParam(value="solapa",defaultValue=StringUtils.EMPTY) String solapa,
		@RequestParam(value="fuelle",defaultValue=StringUtils.EMPTY) String fuelle,
		@RequestParam(value="grMin",defaultValue=StringUtils.EMPTY) String grMin,
		@RequestParam(value="max",defaultValue=StringUtils.EMPTY) String max,
		@RequestParam(value="min",defaultValue=StringUtils.EMPTY) String min,
		@RequestParam(value="maxProd",defaultValue=StringUtils.EMPTY) String maxProd,
		@RequestParam(value="minProd",defaultValue=StringUtils.EMPTY) String minProd,
		@RequestParam(value="scrap",defaultValue=StringUtils.EMPTY) String scrap,
		@RequestParam(value="codTipoManga",defaultValue=StringUtils.EMPTY) String codTipoManga
		
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
				extrusionParte.setCodigoProducto(codProducto);
				extrusionParte.setAncho(ancho);
				extrusionParte.setEspesor(espesor);
				extrusionParte.setTratado(tratado);
				extrusionParte.setSolapa(solapa);
				extrusionParte.setFuelle(fuelle);
				extrusionParte.setGrMLin(grMin);
				extrusionParte.setMaximoMateriaPrima(max);
				extrusionParte.setMinimoMateriaPrima(min);
				extrusionParte.setMaximoProduccion(maxProd);
				extrusionParte.setMinimoProduccion(minProd);
				extrusionParte.setScrap(scrap);
				extrusionParte.setCodigoTipoManga(codTipoManga);
				extrusionParteDAO.registraSalidaExtrusion(extrusionParte);
				
			}catch (Exception e){
				LOG.error(e.getMessage(), e);
			}
			return response;
	}
}
