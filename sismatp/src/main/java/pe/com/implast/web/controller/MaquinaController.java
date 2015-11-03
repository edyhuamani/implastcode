package pe.com.implast.web.controller;

import java.util.ArrayList;
import java.util.List;

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
import pe.com.implast.logic.business.MaquinaBUS;
import pe.com.implast.model.beans.MaquinaBean;
import pe.com.implast.utils.OperadoresUtil;

@Controller
public class MaquinaController {
	
	private static final Logger LOG=Logger.getLogger(MaquinaController.class);
	
	@Autowired
	MaquinaBUS maquinaBUS;
	
	@RequestMapping(value="/mantenimiento/maquinas.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		String viewName="maquina";
		try{
			response.setViewName(viewName);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/listarMaquinas.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseListBean<MaquinaBean> listarProveedores(
			@RequestParam(value="page",defaultValue="1") Integer pagina,
			@RequestParam(value="rows",defaultValue="10")Integer registros 
			){
		ResponseListBean<MaquinaBean> response=new ResponseListBean<MaquinaBean>();
		List<MaquinaBean> listaMaquinas=new ArrayList<MaquinaBean>();
		
		try{
			listaMaquinas=maquinaBUS.listarMaquinasPaginado(pagina,registros);
			Integer totalRegistros = maquinaBUS.totalMaquinas();
			if (totalRegistros==null){
				totalRegistros=0;
			}
			response.setPage(pagina);
			response.setRecords(totalRegistros);
			response.setTotal(OperadoresUtil.obtenerCociente(totalRegistros, registros));
			response.setRows(listaMaquinas);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	
	@RequestMapping(value="/mantenimiento/registrarMaquina.json",method={RequestMethod.GET,RequestMethod.POST})
	public ResponseObjectBean<String> registrarMaquina(
			@RequestParam(value="codigoMaquina",defaultValue="") String codigoMaquina,
			@RequestParam(value="descMaquina",defaultValue="") String descMaquina
			){
		ResponseObjectBean<String> response=new ResponseObjectBean<String>(); 
		try{
			MaquinaBean maquina=new MaquinaBean();
			maquina.setCodigoMaquina(codigoMaquina);
			maquina.setDescMaquina(descMaquina);
			maquinaBUS.crearMaquina(maquina);	
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
}
