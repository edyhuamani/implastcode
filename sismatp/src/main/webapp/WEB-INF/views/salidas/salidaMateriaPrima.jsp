<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaMateriaPrima.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaProduccion.js"></script>

<script type="text/javascript">
	$(function() {
    	
		$( "#txtFechaOrdenTrabajo" ).datepicker();
		
		$( "#txtFechaProduccion" ).datepicker();
		
		$( "#txtFechaEntrega" ).datepicker();
		
    	$( "#cmbTipoManga" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );

    	$( "#cmbMaquina" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );
    	
    	$( "#cmbProducto" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );
    	
    	$( "#cmbCliente" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );
    	
    	
    	$( "#cmbOperador" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );

    	$( "#cmbTipoTurno" )
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );

    	$( "#cmbCodigoMateriaPrima")
    	.selectmenu()
    	.selectmenu("menuWidget")
      	.addClass( "overflow" );
    	
    	$("input[type=submit], input[type=button], button").button()
    	.click(function(event) {
    		event.preventDefault();
    	});
    	
  	});
</script>

<div id="body" class="ready">
	
	<div class="container">
		
		<div class="row">
			<h3>Registro de Salidas de Materias Primas</h3>
			
			<table>
				<tr>
					<td><label>O.T :</label></td>
					<td><input type="text"  id="txtIdOrdenTrabajo"></td>
				
					<td><label>Fecha O.T :</label> </td>
					<td><input type="text" id="txtFechaOrdenTrabajo"></td>

					<td><label>Fecha Entrega :</label> </td>
					<td><input type="text" id="txtFechaEntrega"></td>
					
					<td><label>Maquina:</label></td>
					<td>
						<select  id="cmbMaquina" style="width: 300px;">
									<option>Lamina</option>
									<option>Manga Cerrada</option>
									<option>Manga Abierta 1 Lado</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><label>Cliente:</label></td>
					<td>
						<select  id="cmbCliente" style="width: 300px;">
									<option>Lamina</option>
									<option>Manga Cerrada</option>
									<option>Manga Abierta 1 Lado</option>
						</select>
					</td>
					<td><label>Producto:</label></td>
					<td>
						<select  id="cmbProducto" style="width: 300px;">
									<option>Lamina</option>
									<option>Manga Cerrada</option>
									<option>Manga Abierta 1 Lado</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><label>Tipo Manga:</label></td>
					<td>
						<select  id="cmbTipoManga" style="width: 300px;">
									<option>Lamina</option>
									<option>Manga Cerrada</option>
									<option>Manga Abierta 1 Lado</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="button" value="Registrar Salida"> </td>
					
					<td><input type="button" value="Cancelar"> </td>
				</tr>
			</table>
		</div>
		
		<div class="row">
				<table>
					<tr>
						<td>
							<label>Operario:</label>
						</td>
						<td>
							<select id="cmbOperador" style="width: 300px;">
								<c:forEach var="itemOperador" items="${operadores}">
									<option value="${itemOperador.codigoOperador}">
										${itemOperador.nombreOperador}
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<label>Fecha de Producción:</label>
						</td>
						<td>
							<input type="text" id="txtFechaProduccion"> 
						</td>
					</tr>
					<tr>
						<td><label>Turno:</label></td>
						<td>
							<select  id="cmbTipoTurno" style="width: 150px;">
										<option>A</option>
										<option>B</option>
										<option>C</option>
							</select>
						</td>
					</tr>
				</table>
		</div>
		
		<div >
		<!-- grilla salida produccion -->
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_salidaProduccion"></table>
						<div id="pgrilla_mantenimiento_salidaProduccion"></div>
					</div>
				</div>
		<!-- fin grilla salida produccion -->
		</div>
		
		
		
		<div >
				<div class="row">
					<table>
						<tr>
							<td><label> Seleccione Materia Prima: </label></td>
							<td>
								<select id="cmbCodigoMateriaPrima" style="width: 350px;">
											<c:forEach var="itemMateriaPrima" items="${materiasPrimas}">
												<option value="itemMateriaPrima.codigoMateriaPrima">
													${itemMateriaPrima.descMateriaPrima}</option>
											</c:forEach>
								</select>
							</td>
							<td>
								<input type="button" value="Registrar Materia Prima" id="btnRegistrarMateriaPrima">
							</td>
						</tr>
					</table>
				</div>
		
				<div >
					<!-- grilla salida materia prima-->
						<div class="ready">
							<div>
								<table id="grilla_mantenimiento_salidaMateriaPrima"></table>
								<div id="pgrilla_mantenimiento_salidaMateriaPrima"></div>
							</div>
						</div>
					<!-- fin grilla salida materia prima -->
				</div>
		</div>
		
		
	</div>
</div>
