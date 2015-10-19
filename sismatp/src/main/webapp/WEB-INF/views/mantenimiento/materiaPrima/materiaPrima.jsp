<!-- begin materiaPrima.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/mantenimiento/materiaPrima.js"></script>

<script type="text/javascript"> 
	$(function() {
		$( "#listProveedores" )
		.selectmenu()
		.selectmenu("menuWidget")
	  	.addClass( "overflow" );

		    
		$("input[type=submit], input[type=button], button").button()
		.click(function(event) {
			event.preventDefault();
		});
	});
</script>

<div id="body" style="margin-left: 0">
	
	<!-- <div style="margin: 0 auto 0 auto;width: 800px; ">-->
	<div class="container"> 
		<div class="row">
			
			<div class="panel panel-default">
				<p>Registro Creación de Materias Primas </p>
				
				<form action="" id="frmMateriaPrima">
					<fieldset style="height: 0 auto ;width: 0 auto;">
						<legend>Ingreso de Datos</legend>
						<table>
							<tbody>
								<tr>
									<td><label>Código Materia Prima: </label></td>
									<td><input type="text" id="txtCodigoMateriaPrima" /></td>
								</tr>
								
								<tr>
									<td><label>Descripción:</label></td>
									<td><input type="text" id="txtDescripcion"  maxlength="250" /></td>
								</tr>
								
								<tr>
									<td><label>Codigo Proveedor:</label></td>
									
									<td >
										<select id="listProveedores"  style="font-size: 18px;width: 140px"> 
											<c:forEach var="proveedor" items="${proveedores}">
												<option value="${proveedor.codigoProveedor}">${proveedor.razonSocial} </option>
											</c:forEach>
										</select>
									</td>
								</tr>
								
								<tr>
									<td><input type="button" id="btnRegistrarMateriaPrima" name="Registrar"
										title="Registrar" value="Registrar"></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
				
			</div>
			<br>
			<br>
			<!-- grilla materia primas-->
			<div class="ready">
				<div>
					<table id="grilla_mantenimiento_materiasPrimas"></table>
					<div id="pgrilla_mantenimiento_materiasPrimas"></div>
				</div>
			</div>
			<!-- fin grilla materias primas -->

		</div>
	</div>
	
</div>
<!-- end materiaPrima.jsp -->