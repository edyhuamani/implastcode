package pe.com.implast.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.implast.beans.ResponseObject;
import pe.com.implast.logic.business.ProveedorBUS;
import pe.com.implast.model.beans.ProveedorBean;

@Controller
public class ProveedorController {
	
	@Autowired
	private ProveedorBUS proveedorBUS;
	
	private static final Logger LOG=Logger.getLogger(ProveedorController.class);
	
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
	public ResponseObject<String> registrarProveedor(
		@RequestParam(value="codigoProveedor")String codigoProveedor,
		@RequestParam(value="razonsocial")String razonSocial
		){
		ResponseObject<String> response=new ResponseObject<String>();
		try{
			ProveedorBean proveedor=new ProveedorBean();
			proveedor.setIdProveedor(Integer.valueOf(codigoProveedor).intValue());
			proveedor.setRazonSocial(razonSocial);
			proveedorBUS.crearProveedor(proveedor);
		}catch(Exception e){
			LOG.error(e);
		}
		return response;
	}
}
