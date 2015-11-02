<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/ingresoMateriaPrima.js"></script>
<script type="text/javascript">
	$(function(){
		
		$( "#txtFechaDocumento" ).datepicker({ dateFormat: 'dd-mm-yy' });
		
		$("input[type=submit], input[type=button], button").button()
    	.click(function(event) {
    		event.preventDefault();
    	});
		
		$( "#cmbProveedor" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );
		
		$( "#cmbMateriaPrima" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );
    	
		
	});
</script>
	
<div id="body" class="ready">
		<div class="container">
				
				<div class="row">
					<h3>Registro de Ingreso de Materias Primas</h3>
					
						<table>
							<tr>
								<td><label style="width: 200px;">Documento de Ingreso:</label></td>
								<td>
									<input type="text" id="txtDocumentoIngreso" style="width: 200px;">
								</td>
								<td>
									<label style="width: 150px;margin-left: 10px">Fecha:</label>
								</td>
								<td>
									<input type="text" id="txtFechaDocumento"  style="z-index: 900!important;"> 
								</td>
							</tr>
							<tr>
								<td><label style="width: 200px;">Proveedor:</label></td>
								<td>
									<select  id="cmbProveedor" style="width:250px;font-size:14px;height: auto;">
										<c:forEach var="proveedorItem" items="${proveedores}">
											<option value="${proveedorItem.codigoProveedor} ">${proveedorItem.razonSocial} </option>
										</c:forEach>
									</select>
								</td>
								<td></td>
								<td></td>
							</tr>
							
							<tr>
								<td><label style="width: 120px;">Materia Prima:</label></td>
							
								<td>
									<select id="cmbMateriaPrima" style="width:250px;font-size: 14px;height: auto;">
										<c:forEach var="itemMateriaP" items="${materiasPrimas}">	
											<option value="${itemMateriaP.codigoMateriaPrima}">${itemMateriaP.descMateriaPrima}</option>	
										</c:forEach>
									</select>
								</td>
								
								<td><label style="width: 150px;margin-left: 10px">Cantidad :</label></td>
								
								<td><input type="text" id="txtCantidadIngresoMP"></td>
									
								<td>
									<input type="submit" value="Adicionar Materia Prima" id="btnAdicionarMateriaPrima" style="margin-left: 10px"/>
								</td>
							</tr>
						</table>
					
				</div>

				<br>
				<br>
				<!-- grilla proveedor-->
				<div class="ready" style="z-index: -1!important;position: relative;">
					<div>
						<table id="grilla_mantenimiento_ingresoMateriaPrima"></table>
						<div id="pgrilla_mantenimiento_ingresoMateriaPrima"></div>
					</div>
				</div>
				<!-- fin grilla proveedor -->
				
				<br>
				<br>
				<div>
						<table>
							<tr>
								<td><input type="submit" value="Registrar Ingreso"></td>
								<td><input type="submit" value="Cancelar"></td>
							</tr>
						</table>
					
				</div>	
		</div>
</div>


