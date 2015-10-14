package pe.com.implast.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.beans.ResponseObjectBean;
import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.logic.business.ProveedorBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.ProveedorBean;
import pe.com.implast.utils.OperadoresUtil;

@Controller
public class MateriaPrimaController {
	
	@Autowired
	private MateriaPrimaBUS materiaPrimaBUS;
	
	@Autowired
	private ProveedorBUS proveedorBUS;
	
	private static final Logger LOG=Logger.getLogger(MateriaPrimaController.class); 
	
	@RequestMapping(value="/mantenimiento/materiaPrima.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView model=new ModelAndView();
		List<ProveedorBean> proveedores=new ArrayList<ProveedorBean>();
		String viewName=StringUtils.EMPTY;
		try{
			viewName="materiaPrima";
			model.setViewName(viewName);
			proveedores=proveedorBUS.obtenerListaProveedores();
			model.addObject("proveedores", proveedores);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return model;
	}
	
	@RequestMapping(value="/mantenimiento/listarMateriasPrimas.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseListBean<MateriaPrimaBean> listarMateriaPrimas(
		@RequestParam(value="page",defaultValue="1") Integer pagina,
		@RequestParam(value="rows",defaultValue="10")Integer registros ){
		
		ResponseListBean<MateriaPrimaBean> response=new ResponseListBean<MateriaPrimaBean>();
		List<MateriaPrimaBean> listaMateriasPrimas=new ArrayList<MateriaPrimaBean>();
		
		try{
			listaMateriasPrimas=materiaPrimaBUS.listarMateriasPrimas(pagina,registros);
			Integer totalRegistros = materiaPrimaBUS.totalMateriasPrimas();
			response.setPage(pagina);
			response.setRecords(totalRegistros);
			response.setTotal(OperadoresUtil.obtenerCociente(totalRegistros, registros));
			response.setRows(listaMateriasPrimas);
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
		
	
	@RequestMapping(value="/mantenimiento/registrarMateriaPrima.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseObjectBean<String> registrarMateriaPrima(
			@RequestParam(value="codigoMateriaPrima",defaultValue=StringUtils.EMPTY) String codigoMateriaPrima,
			@RequestParam(value="descripcion",defaultValue=StringUtils.EMPTY ) String descripcion,
			@RequestParam(value="codigoProveedor",defaultValue=StringUtils.EMPTY) String codigoProveedor
			){
		//List<MensajeValidacionBean> listaMensajesValidacionBeans = new ArrayList<>();
		ResponseObjectBean<String> response=new ResponseObjectBean<String>();
		try{
			
			
			
			MateriaPrimaBean mp=new MateriaPrimaBean();
			mp.setIdMateriaPrima(Integer.valueOf(codigoMateriaPrima));
			mp.setCodigoMateriaPrima(codigoMateriaPrima);
			mp.setDescripcion(descripcion);
			mp.setCodigoProveedor(codigoProveedor);
			materiaPrimaBUS.crearMateriaPrima(mp);
			
			
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
}
