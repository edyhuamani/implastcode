<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/ingresoMateriaPrima.js"></script>
<script type="text/javascript">
	$(function(){
		
		$( "#txtFechaDocumento" ).datepicker();
		
		$("input[type=submit], input[type=button], button").button()
    	.click(function(event) {
    		event.preventDefault();
    	});
		
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
				<fieldset>
					
					<table>
						<tr>
							<td><label>Documento de Ingreso:</label></td>
							<td>
								<input type="text" id="txtDocumentoIngreso">
							</td>
							<td>
								<label>Fecha:</label>
							</td>
							<td>
								<input type="text" id="txtFechaDocumento">
							</td>
						</tr>
						<tr>
							<td><label>Seleccione Materia Prima:</label></td>
						
							<td>
								<select id="cmbMateriaPrima" style="width: 180px;">
									<c:forEach var="itemMateriaP" items="${materiasPrimas}">	
										<option value="${itemMateriaP.codigoMateriaPrima}">${itemMateriaP.descMateriaPrima}</option>	
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" value="Adicionar Materia Prima" id="btnAdicionarMateriaPrima"/>
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="Rgistrar Ingreso"></td>
							<td><input type="submit" value="Cancelar"></td>
						</tr>
					</table>
					
					
				</fieldset>
				
			</div>
			
			<div>
			<!-- grilla proveedor-->
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_ingresoMateriaPrima"></table>
						<div id="pgrilla_mantenimiento_ingresoMateriaPrima"></div>
					</div>
				</div>
			<!-- fin grilla proveedor -->
			</div>
			
		</div>
	</div>


