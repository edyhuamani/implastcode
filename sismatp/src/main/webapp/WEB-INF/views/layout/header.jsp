<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!-- 
	<script type="text/javascript" >
		$(document).ready(function(){
			
		});
	</script>
	-->

<!-- menu api inicio -->
<link type="text/css" href="<%=request.getContextPath()%>/jquery/js/menu.css" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/menu.js"></script>
<!-- menu api fin  -->

<spring:url value="/img/iconos/close.png" var="close"></spring:url>
<spring:url value="/img/logo_impresiones.jpg" var="logoImpresiones"></spring:url>	
<spring:url value="http://localhost:8080/sismatp" var="homeurl"></spring:url>	

<!-- Bootstrap -->
<link type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css" rel="stylesheet">
	
<!-- header -->
<div id="header">
	<form id="idFormSession">
		<table style="background-color: #FFFFFF;">
			<tbody>
				<tr>
					<td width="60%" align="left" style="padding-left: 0px; min-width: 280px">
						<a href="${homeurl}" style="border: 0px"><img src="${logoImpresiones}" border="0" hspace="0" width="279" height="100" /></a>
					</td>
				</tr>
				
				<!-- 
				<tr>
					<td align="right" colspan="2">
						<span class="arial11rojobold">Usuario:</span>&nbsp;
						<span class="arial11"><strong>${username}</strong></span>&nbsp;   
					</td>
				</tr>
														
				<tr>
					<td align="left">
						<a href="javascript:void(0);" onclick="cerrarCession();" style="text-decoration: none;padding-right: 2px;vertical-align: middle;">
							<img alt="Cerrar Sesión" src="${close}" width="22px" height="22px"  border="0" hspace="0" title="Cerrar Sesión" />
						</a>
						&nbsp;&nbsp;&nbsp; 
					</td>
				</tr>
				 -->
			</tbody>
		</table>
	</form>
</div>	
	
<div id="tabs">
	<div id="menu">
		<ul class="menu">
			<li style="width: 300px;"><a href="#" class="parent"
				style="width: 260px;"><span style="text-align: center;">Mantenimiento</span></a>
				<div>
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/materiaPrima.htm">
								<span>Materias Primas</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/proveedor.htm">
								<span>Proveedores</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/parametro/mantenimientoParametros.htm">
								<span>Par&aacute;metro</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/producto/mantenimiento-productos.htm">
								<span>Colaboradores</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/estructura/mantenimiento-estructuras.htm">
								<span>Estructuras</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/crctr-especial/mantenimiento-crctr-especial.htm">
								<span>Caracter Especial</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/validacionIdentidadManual/validacionIdentidadManual.htm">
								<span>Validacion Indentidad Manual</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/validacionCaracterManual/validacionCaracterManual.htm">
								<span>Validacion Caracter Manual</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/mantenimiento/catalogoColumn/mantenimiento-catalogoColumn.htm"><span>Catalogo
									Columna</span> </a></li>
					</ul>
				</div></li>

			<li style="width: 300px;"><a href="#" class="parent"
				style="width: 270px;"><span style="text-align: center;">Herramientas</span></a>
				<div>
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/herramientas/adminPerfiles/adminPerfiles.htm">
								<span>Administracion de Perfiles</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/herramientas/entidades/buscarEntidad.htm">
								<span>Buscar Entidades, Subentidades, Usuarios</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/consultas/registrocartera/consRegisCartera.htm">
								<span>Consulta Registro de Cartera</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/consultas/elimorososentidades/eliDocMorosos.htm">
								<span>Eliminar Doc. Morosos Entidades</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/herramientas/cargaClientesESP/cargaClientesESP.htm">
								<span>Carga Clientes Especiales</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/herramientas/cargaClientesSCI/cargaClientesSCI.htm">
								<span>Importacion de Clientes de SCI</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/herramientas/importacionREPCOM/importacionREPCOM.htm">
								<span>Importacion de Representantes Comerciales</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/herramientas/perfilUsuarios/perfilUsuarios.htm">
								<span>Perfiles por Usuario</span>
						</a></li>
					</ul>
				</div></li>

			<li style="width: 300px;"><a href="#" class="parent"
				style="width: 270px;"><span style="text-align: center;">Procesos</span></a>
				<div>
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/procesos/ingresoMateriaPrima.htm">
								<span>Registro de Ingresos</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/procesos/salidaMateriaPrima.htm">
								<span>Registro de Salidas</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/procesos/cargaPadrones/cargaPadrones.htm">
								<span>Carga Padrones</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/procesos/consultaRucDniPadron/consulta-Ruc-Dni-Padron.htm">
								<span>Consulta RUC/DNI Padr&oacute;n</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/procesos/consulta-correos/consulta-envio-correos.htm">
								<span>Consulta Correos</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/procesos/exportacionHost/exportacionHost.htm">
								<span>Exportacion Host</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/procesos/monitoreo/monitoreoProceso.htm">
								<span>Monitoreo de Procesos</span>
						</a></li>
					</ul>
				</div></li>


			<li style="width: 300px;"><a href="#" class="parent"
				style="width: 270px;"><span style="text-align: center;">Consultas</span></a>
				<div>
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/consultas/consultaIngresos.htm">
								<span>Consulta de Ingreso de Materias Primas</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/consultas/consultaSalidas.htm">
								<span>Consulta de Salidas de Materias Primas</span>
						</a></li>
						<li><a
							href="<%=request.getContextPath()%>/consultas/documentosMorosos/consulta-general-documentos-morosos.htm">
								<span>Consulta Registro de Materias Primas</span>
						</a></li>
						<%-- <li><a href="<%=request.getContextPath()%>/consultas/rucdni/consRucDni.htm"> <span>Consulta RUC/DNI padrón</span>
                        </a></li>
                        <li><a href="<%=request.getContextPath()%>/consultas/registroelimin/consRegisElim.htm"> <span>Consulta Registros Eliminados</span>
                        </a></li>
                        <li><a href="<%=request.getContextPath()%>/consultas/registrorecha/consRegisRecha.htm"> <span>Consulta Registro Rechazados</span>
                        </a></li> --%>
					</ul>
				</div></li>

		</ul>
	
	</div>
	<!-- No eliminar esta linea -->
	<a href="http://apycom.com/" style="color: white;">Apycom jQuery Menus</a>
</div>


