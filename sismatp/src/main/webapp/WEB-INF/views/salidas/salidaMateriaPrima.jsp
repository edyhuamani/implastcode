<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaMateriaPrima.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaProduccion.js"></script>

<div id="body">
	<div class="container">
		<div class="row">
			<h3>Registro de Salidas de Materias Primas</h3>
			<table>
				<tr>
					<td><label> Seleccione Materia Prima: </label></td>
					<td>
						<select id="cmbCodigoMateriaPrima">
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
					
				<tr>

				</tr>
				<tr>
					<td>
						<label>Operario:</label>
					</td>
					<td>
						<select id="cmbOperador">
							<c:forEach var="itemOperador" items="${listaOperadores}">
								<option value="${itemOperador.codigoOperador}">
									${itemOperador.nombreOperador}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label>Supervisor:</label>
					</td>
					<%-- <td>
						<select id="cmbSupervisor">
							<c:forEach  var="" items="">
								<option>
								</option>
							</c:forEach>
						</select>
						
					</td> --%>
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
