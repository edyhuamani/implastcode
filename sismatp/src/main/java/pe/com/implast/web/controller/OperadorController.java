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
import pe.com.implast.logic.business.OperadorBUS;
import pe.com.implast.model.beans.OperadorBean;
import pe.com.implast.utils.ConstantesUtil;
import pe.com.implast.utils.OperadoresUtil;

@Controller
public class OperadorController {
	
	private static final Logger LOG=Logger.getLogger(OperadorController.class); 
	
	@Autowired
	OperadorBUS operadorBUS;
	
	@RequestMapping(value="/mantenimiento/operador.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView model=new ModelAndView();
		try{
			String viewName="operador";
			model.setViewName(viewName);;
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return model;
	}
	
	@RequestMapping(value="/mantenimiento/listarOperador.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseListBean<OperadorBean> listarMateriaPrimas(
		@RequestParam(value="page",defaultValue="1") Integer pagina,
		@RequestParam(value="rows",defaultValue="10")Integer registros ){
		
		ResponseListBean<OperadorBean> response=new ResponseListBean<OperadorBean>();
		List<OperadorBean> listaOperador=new ArrayList<OperadorBean>();
		
		try{
			listaOperador=operadorBUS.listarOperadorPaginado(pagina,registros);
			Integer totalRegistros = operadorBUS.totalOperadores();
			response.setPage(pagina);
			response.setRecords(totalRegistros);
			response.setTotal(OperadoresUtil.obtenerCociente(totalRegistros, registros));
			response.setRows(listaOperador);
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/registrarOperador.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseObjectBean<String> registrarOperador(
			@RequestParam(value="codigoOperador",defaultValue=StringUtils.EMPTY) String codigoOperador,
			@RequestParam(value="nombreOperador",defaultValue=StringUtils.EMPTY) String nombreOperador
			){
		ResponseObjectBean<String> response=new ResponseObjectBean<String>();
		try{
			OperadorBean operador=new OperadorBean();
			operador.setIdOperador(Integer.valueOf(codigoOperador));
			operador.setCodigoOperador(codigoOperador);
			operador.setNombreOperador(nombreOperador);
			operadorBUS.crearOperador(operador);
			response.setRespuesta(ConstantesUtil.RESPUESTA_OK);
		}catch(Exception e){
			response.setRespuesta(ConstantesUtil.RESPUESTA_ERROR_VALIDACION);
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
}
