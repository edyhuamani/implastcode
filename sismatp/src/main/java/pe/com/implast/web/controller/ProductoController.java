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

import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.logic.business.ProductoBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.ProductoBean;

@Controller
public class ProductoController {
	
	private static final Logger LOG=Logger.getLogger(ProductoController.class);  
	
	@Autowired
	ProductoBUS productoBUS;
	
	@RequestMapping(value="/mantenimiento/producto.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response =new ModelAndView();
		String viewName="producto"; 
		try{
			response.setViewName(viewName);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/listarProductos.json",method={RequestMethod.POST,RequestMethod.GET},produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseListBean<MateriaPrimaBean> listarProductos(
		@RequestParam(value="page",defaultValue="1") Integer pagina,
		@RequestParam(value="rows",defaultValue="10")Integer registros ){
		
		ResponseListBean<MateriaPrimaBean> response=new ResponseListBean<MateriaPrimaBean>();
		List<ProductoBean> listarProductos=new ArrayList<ProductoBean>();
		
		try{
			listarProductos=productoBUS.listarProductosPaginado(pagina,registros);
//			Integer totalRegistros = materiaPrimaBUS.totalMateriasPrimas();
//			response.setPage(pagina);
//			response.setRecords(totalRegistros);
//			response.setTotal(OperadoresUtil.obtenerCociente(totalRegistros, registros));
//			response.setRows(listaMateriasPrimas);
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
	
}
