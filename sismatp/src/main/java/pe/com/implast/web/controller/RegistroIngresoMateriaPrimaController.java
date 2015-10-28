package pe.com.implast.web.controller;

import java.util.ArrayList;
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

import pe.com.implast.beans.MensajeValidacionBean;
import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.beans.ResponseObjectBean;
import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.logic.business.OperadorBUS;
import pe.com.implast.logic.business.ProveedorBUS;
import pe.com.implast.logic.business.RegistroMateriaPrimaBUS;
import pe.com.implast.model.beans.IngresoMateriaPrimaBean;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.OperadorBean;
import pe.com.implast.model.beans.ProveedorBean;

@Controller
public class RegistroIngresoMateriaPrimaController {
		
	private static final Logger LOG=Logger.getLogger(RegistroIngresoMateriaPrimaController.class);
	
	@Autowired
	MateriaPrimaBUS materiaPrimaBUS;
	
	@Autowired
	OperadorBUS operadorBUS;
	
	@Autowired
	ProveedorBUS proveedorBUS;
	
	@Autowired
	RegistroMateriaPrimaBUS registroMateriaPrimaBUS;
	
	private List<IngresoMateriaPrimaBean> listMateriasPrimas;
	
	@RequestMapping(value="/procesos/ingresoMateriaPrima.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		List<MateriaPrimaBean> materiasPrimas=null; 
		List<OperadorBean> operadores=null;
		List<ProveedorBean> proveedores=null;
		try{
			String viewName="ingresoMateriaPrima";
			materiasPrimas=materiaPrimaBUS.listarMaterias();
			operadores=operadorBUS.listarOperador();
			proveedores=proveedorBUS.obtenerListaProveedores();
			response.addObject("materiasPrimas", materiasPrimas);
			response.addObject("operadores", operadores);
			response.addObject("proveedores",proveedores);	
			response.setViewName(viewName);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
	
	
	
	@RequestMapping(value="/procesos/adicionarMateriaPrima.json",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseObjectBean<String> adicionarMateriaPrima(
			@RequestParam(value="codigoMateriaPrima") String codigoMateriaPrima,
			@RequestParam(value="cantidadMateriaPrima") String cantidadMateriaPrima
			){
		ResponseObjectBean<String> response=new ResponseObjectBean<String>(); 
		List<MensajeValidacionBean> listaMensajesValidacionBeans = new ArrayList<MensajeValidacionBean>();
		
		try{

			IngresoMateriaPrimaBean ingresoMatP=new IngresoMateriaPrimaBean();
			materiaPrimaBUS.obtenerMateriaPrima(codigoMateriaPrima);
			ingresoMatP.setCodigoMateriaPrima(codigoMateriaPrima);
			ingresoMatP.setCantidad(Integer.valueOf(cantidadMateriaPrima).intValue());
			listMateriasPrimas.add(ingresoMatP);
			
		}catch (Exception e){
			LOG.error(e.getMessage() , e);
		}
		return response;
	}
	
	
	@RequestMapping(value="/procesos/recargar-grilla-adicionarMateriaPrima.json",method={RequestMethod.GET})
	public @ResponseBody ResponseListBean<IngresoMateriaPrimaBean> recargaGrillaMateriaPrima(){
		ResponseListBean<IngresoMateriaPrimaBean> response=new ResponseListBean<IngresoMateriaPrimaBean>();
		try{
			response.setRows(listMateriasPrimas);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
}
