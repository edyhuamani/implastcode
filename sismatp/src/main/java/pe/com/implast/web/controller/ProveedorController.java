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

import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.beans.ResponseObjectBean;
import pe.com.implast.logic.business.ProveedorBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.beans.ProveedorBean;
import pe.com.implast.utils.OperadoresUtil;

@Controller
public class ProveedorController {
	
	private static final Logger LOG=Logger.getLogger(ProveedorController.class);
	
	@Autowired
	private ProveedorBUS proveedorBUS;
	
	@RequestMapping(value="/mantenimiento/proveedor.htm",method={RequestMethod.GET})
	public String init(){
		String viewName="proveedor";
		try{
			viewName="proveedor";
		}catch(Exception e){
			LOG.error(e);
		}
		return viewName;
	}
	
	
	@RequestMapping(value="/mantenimiento/registrarProveedor.json",produces="application/json")
	@ResponseBody
	public ResponseObjectBean<String> registrarProveedor(
		@RequestParam(value="codigoProveedor",defaultValue=StringUtils.EMPTY)String codigoProveedor,
		@RequestParam(value="razonSocial",defaultValue=StringUtils.EMPTY)String razonSocial
		){
		
		ResponseObjectBean<String> response=new ResponseObjectBean<String>();
		try{
			ProveedorBean proveedor=new ProveedorBean();
			proveedor.setIdProveedor(Integer.valueOf(codigoProveedor).intValue());
			proveedor.setCodigoProveedor(codigoProveedor);
			proveedor.setRazonSocial(razonSocial);
			proveedorBUS.crearProveedor(proveedor);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/listarProveedores.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseListBean<ProveedorBean> listarProveedores(
			@RequestParam(value="page",defaultValue="1") Integer pagina,
			@RequestParam(value="rows",defaultValue="10")Integer registros 
			){
		ResponseListBean<ProveedorBean> response=new ResponseListBean<ProveedorBean>();
		List<ProveedorBean> listaProveedores=new ArrayList<ProveedorBean>();
		
		try{
			listaProveedores=proveedorBUS.listarProveedoresPaginado(pagina,registros);
			Integer totalRegistros = proveedorBUS.totalProveedores();
			
			response.setPage(pagina);
			response.setRecords(totalRegistros);
			response.setTotal(OperadoresUtil.obtenerCociente(totalRegistros, registros));
			response.setRows(listaProveedores);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
}
