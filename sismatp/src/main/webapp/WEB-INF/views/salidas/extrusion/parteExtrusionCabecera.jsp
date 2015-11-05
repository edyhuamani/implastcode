<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/extrusionRegistro/parteExtrusion.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaMezcla.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaProduccion.js"></script>



<style>
    fieldset {
      border: 0;
    }
    label {
      display: block;
      margin: 5px 0 0 0;
    }
    select {
      width: 200px;
    }
    .overflow {
      height: 200px;
    }
  </style>


<div id="body" class="ready">
	
	<div class="container">
		
		<div class="row">
			<h3>Extrusion Parte (Cabecera) </h3>
			
			<table>
				
				<tr>
					<!--Orden de Trabajo-->
					<td ><label style="width: 120px;">O.T :</label></td>
					<td><input type="text"  id="txtIdOrdenTrabajo"></td>
				
					<!-- Fecha orden de Trabajo-->
					<td ><label style="width: 150px;margin-left: 10px;">Fecha O.T :</label> </td>
					<td><input type="text" id="txtFechaOrdenTrabajo" style="z-index: 900!important;"></td>

					<!-- fecha Entrega -->
					<td ><label style="width: 150px;margin-left: 10px;">Fecha Entrega :</label> </td>
					<td><input type="text" id="txtFechaEntrega"></td>
				</tr>
				
				<tr>
					<!-- SAP -->
					<td><label style="width: 120px;">SAP :</label></td>
					<td><input type="text"  id="txtSAP"></td>
					
					<!-- Maquina -->
					<td ><label style="width: 150px;margin-left: 10px;">Maquina:</label></td>
					<td>
						<select  id="cmbMaquina" style="width: 300px;">
								<c:forEach var="itemMaquina" items="${maquinas}">
									<option value="${itemMaquina.codigoMaquina}">${itemMaquina.descMaquina}</option>
								</c:forEach>
						</select>
					</td>
					
					<!-- Status -->
					<td ><label style="width: 120px;margin-left: 10px;" >Status:</label></td>
					<td><input type="text"  id="txtStatus"></td>
				</tr>
				
				<tr>
					<!-- Cliente -->
					<td><label style="width: 120px;">Cliente:</label></td>
					<td>
						<select  id="cmbCliente" style="width: 300px;">
								<c:forEach var="itemCliente" items="${clientes}">
									<option value="${itemCliente.codigoCliente}">${itemCliente.razonSocial}</option>
								</c:forEach>	
						</select>
					</td>
				</tr>
				
				<tr>
					<!-- Producto -->
					<td><label style="width: 120px;">Producto:</label></td>
					<td>
						<select  id="cmbProducto" style="width: 300px;" onchange="alert();" >
								<c:forEach var="itemProducto" items="${productos}">	
									<option value="${itemProducto.codigoProducto}">${itemProducto.descripcion}</option>
								</c:forEach>	
						</select>
					</td>
					
					<!-- Ancho-->
					<td ><label style="width: 150px;margin-left: 10px;">Ancho :</label> </td>
					<td><input type="text" id="txtAncho" ></td>

					<!-- Espesor -->
					<td ><label style="width: 150px;margin-left: 10px;">Espesor :</label> </td>
					<td><input type="text" id="txtEspesor" value="0.00"></td>
				</tr>
				
				
				
				<tr>
					<!-- Tratado -->
					<td><label style="width: 120px;" >Tratado:</label></td>
					
					<td>
						<select  id="cmbTratado" style="width: 300px;">
									<option>Total</option>
									<option>Fraccionado</option>
									<option>Ninguno</option>
									<option>1 Cara</option>
									<option>2 Cara</option>
						</select>
					</td>
					
					<!-- <td><input type="text" id="txtTratado"></td> -->

					
					<!-- Solapa-->
					<td ><label style="width: 150px;margin-left: 10px;">Solapa :</label> </td>
					<td><input type="text" id="txtSolapa"></td>

					<!-- Fuelle -->
					<td ><label style="width: 150px;margin-left: 10px;">Fuelle :</label> </td>
					<td><input type="text" id="txtFuelle"></td>
				</tr>
				
				
				<tr>
					<!-- Gr.m.lin -->
					<td><label style="width: 120px;">Gr/m.lin:</label></td>
					<td><input type="text" id="txtGrMin" value="0.00"></td>
					
					<!-- Max-->
					<td ><label style="width: 150px;margin-left: 10px;">Max :</label></td>
					<td><input type="text" id="txtMax" value="0.00"></td>

					<!-- Min -->
					<td ><label style="width: 150px;margin-left: 10px;">Min :</label></td>
					<td><input type="text" id="txtMin" value="0.00"></td>
				</tr>
				
			
			</table>
			
			
			<div >
			<!-- grilla salida produccion -->
				<div class="ready" style="z-index: -1!important;">
						<table id="grilla_mantenimiento_salidaMezcla"></table>
						<div id="pgrilla_mantenimiento_salidaMezcla"></div>
				</div>
			<!-- fin grilla salida produccion -->
			</div>
			
			<table>
				<tr>
					<!-- Max-->
					<td ><label style="width: 120px;">Max :</label> </td>
					<td><input type="text" id="txtMaxProduccion" value="0.00"></td>

					<!-- Min -->
					<td ><label style="width:150px;margin-left: 10px;">Min :</label> </td>
					<td><input type="text" id="txtMinProduccion" value="0.00"></td>
					
					<!-- Tratado -->
					<td><label style="width: 150px;margin-left: 10px;">Scrap maximo:</label></td>
					<td><input type="text" id="txtScrapMaximo" value="0.00"></td>
				</tr>
				
				<tr>
					<td><label style="width: 120px;">Tipo Manga:</label></td>
					<td>
						<select  id="cmbTipoManga" style="width: 300px;">
									<option>Lamina</option>
									<option>Manga Cerrada</option>
									<option>Manga Abierta 1 Lado</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<br>
			
			<table>
				<tr>
					<td><input type="button" value="Registrar Salida" id="btnRegistrarSalida"> </td>
					
					<td><input type="button" value="Cancelar" id="btnCancelarSalida">  </td>
				</tr>
			</table>	
			
			
		</div>
		
		<br>
		<br>
		
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
							<input type="text" id="txtFechaProduccion" style="z-index: 900!important"> 
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
		
	
		
		<input type="button" value="Agregar Productos">
		
		<div >
		<!-- grilla salida produccion -->
				<div class="ready" style="z-index: -1!important;">
						<table id="grilla_mantenimiento_salidaProduccion"></table>
						<div id="pgrilla_mantenimiento_salidaProduccion"></div>
				</div>
		<!-- fin grilla salida produccion -->
		</div>
		
		
		
		<div >
				<div class="row">
					<table>
						<tr>
							<td><label> Seleccione Materia Prima: </label></td>
							<td>
								<select id="cmbCodigoMateriaPrima" style="width: 350px;" onchange="javascript:seleccionProducto();">
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
		
				<input type="button" value="Registrar Materia Prima">
		
				<div >
					<!-- grilla salida materia prima-->
						<div class="ready" style="z-index: -1!important;">
							
								<table id="grilla_mantenimiento_salidaMateriaPrima"></table>
								<div id="pgrilla_mantenimiento_salidaMateriaPrima"></div>
							
						</div>
					<!-- fin grilla salida materia prima -->
				</div>
		</div>
		
		
	</div>
</div>
