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

import pe.com.implast.beans.MensajeValidacionBean;
import pe.com.implast.beans.ResponseListBean;
import pe.com.implast.beans.ResponseObjectBean;
import pe.com.implast.logic.business.ClienteBUS;
import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.utils.OperadoresUtil;

@Controller
public class ClienteController {
	
	private static final Logger LOG=Logger.getLogger(ClienteController.class);
	
	@Autowired
	ClienteBUS clienteBUS;
	
	@RequestMapping(value="/mantenimiento/clientes.htm",method={})
	public ModelAndView init(){
		ModelAndView response=new ModelAndView();
		String viewName="cliente";
		try{
			response.setViewName(viewName);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/listarClientes.json",method={RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody ResponseListBean<ClienteBean> listarClientes(
			@RequestParam(value="page",defaultValue="1") Integer pagina,
			@RequestParam(value="rows",defaultValue="10")Integer registros 
			){
		ResponseListBean<ClienteBean> response=new ResponseListBean<ClienteBean>();
		List<ClienteBean> listaClientes=new ArrayList<ClienteBean>();
		
		try{
			listaClientes=clienteBUS.listarClientesPaginado(pagina,registros);
			Integer totalRegistros = clienteBUS.totalClientes();
			if (totalRegistros==null){
				totalRegistros=0;
			}
			response.setPage(pagina);
			response.setRecords(totalRegistros);
			response.setTotal(OperadoresUtil.obtenerCociente(totalRegistros, registros));
			response.setRows(listaClientes);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	@RequestMapping(value="/mantenimiento/registrarCliente.json",produces=MediaType.APPLICATION_JSON)
	
	public @ResponseBody ResponseObjectBean<String> registrarCliente(
		@RequestParam(value="codigoCliente",defaultValue=StringUtils.EMPTY)String codigoCliente,
		@RequestParam(value="razonSocial",defaultValue=StringUtils.EMPTY)String razonSocial,
		@RequestParam(value="rucCliente",defaultValue=StringUtils.EMPTY)String rucCliente,
		@RequestParam(value="telefono",defaultValue=StringUtils.EMPTY)String telefono,
		@RequestParam(value="nombreContacto",defaultValue=StringUtils.EMPTY)String nombreContacto,
		@RequestParam(value="apellidosContacto",defaultValue=StringUtils.EMPTY)String apellidosContacto
			){
		
		List<MensajeValidacionBean> listaMensajesValidacionBeans = new ArrayList<MensajeValidacionBean>();
		ResponseObjectBean<String> response=new ResponseObjectBean<String>();
		try{
			ClienteBean cliente=new ClienteBean();
			cliente.setCodigoCliente(codigoCliente);
			cliente.setRazonSocial(razonSocial);
			cliente.setRuc(rucCliente);
			cliente.setTelefono(telefono);
			cliente.setNombres(nombreContacto);
			cliente.setApellidos(apellidosContacto);
			
			clienteBUS.crearCliente(cliente);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
		return response;
	}
}
