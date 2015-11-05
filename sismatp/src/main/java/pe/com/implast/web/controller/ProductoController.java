package pe.com.implast.web.controller;

import java.util.ArrayList;
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

import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.beans.ResponseObjectBean;
import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.logic.business.ProductoBUS;
import pe.com.implast.model.beans.IngredienteBean;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.MezclaBean;
import pe.com.implast.model.beans.ProductoBean;

@Controller
public class ProductoController {
	
	private static final Logger LOG=Logger.getLogger(ProductoController.class);  
	
	@Autowired
	ProductoBUS productoBUS;
	
	@Autowired
	MateriaPrimaBUS materiaPrimaBUS;
	
	List<IngredienteBean> ingredientes;
	
	public ProductoController() {
		this.ingredientes=new ArrayList<IngredienteBean>();
	}
	
	
	@RequestMapping(value="/mantenimiento/producto.htm",method={RequestMethod.GET})
	public ModelAndView init(){
		ModelAndView response =new ModelAndView();
		String viewName="producto";
		List<MateriaPrimaBean> materiasPrimas=null;
		try{
			materiasPrimas=materiaPrimaBUS.listarMaterias();
			response.addObject("materiasPrimas",materiasPrimas);
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
	
	@RequestMapping(value="/mantenimiento/registrarIngrediente.json",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON)
	public  @ResponseBody ResponseListBean<IngredienteBean>  registrarMateriaPrima(
			@RequestParam(value="codigoMateriaPrima",defaultValue=StringUtils.EMPTY) String codigoMateriaPrima,
			@RequestParam(value="porcentaje",defaultValue=StringUtils.EMPTY) String porcentaje,
			@RequestParam(value="cantidad",defaultValue=StringUtils.EMPTY) String cantidad
			
			){
		ResponseListBean<IngredienteBean> response=new ResponseListBean<IngredienteBean>();
		try{
			IngredienteBean ingrediente=new IngredienteBean();
			MateriaPrimaBean materiaP=new MateriaPrimaBean();
			materiaP=materiaPrimaBUS.obtenerMateriaPrima(codigoMateriaPrima);
			ingrediente.setMateriaPrima(materiaP);
			ingrediente.setCantidad(Double.parseDouble(cantidad));
			ingrediente.setPorcentaje(Double.parseDouble(porcentaje));
			ingredientes.add(ingrediente);
			response.setRows(ingredientes);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/listar-ingredientes.json",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseListBean<IngredienteBean> listarIngredientes(){
		ResponseListBean<IngredienteBean> response=new ResponseListBean<IngredienteBean>();
		try{
			response.setRows(ingredientes);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/registrarProducto.json",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseObjectBean<String> registrarProducto(
			@RequestParam(value="codProducto",defaultValue=StringUtils.EMPTY) String codProducto,
			@RequestParam(value="descProducto",defaultValue=StringUtils.EMPTY) String descProducto
			
			){
		ResponseObjectBean<String> response=new ResponseObjectBean<String>();
		try{
			MezclaBean mezcla=new MezclaBean(); 
			mezcla.setIngredientes(ingredientes);
			ProductoBean producto=new ProductoBean();
			producto.setCodigoProducto(codProducto);
			producto.setDescripcion(descProducto);
			producto.setMezcla(mezcla);
			productoBUS.crearProducto(producto);
			// limpieza 
			ingredientes.clear();
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
}
