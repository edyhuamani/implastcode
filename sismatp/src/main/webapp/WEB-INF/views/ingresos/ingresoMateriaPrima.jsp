<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/ingresoMateriaPrima.js"></script>

	<div id="body">
		<div class="container">
			<div class="row">
				<h3>Registro de Ingreso de Materias Primas</h3>
				<fieldset>
					<table>
						<tr>
						</tr>
						<tr>
							<td><label>Seleccione Materia Prima:</label></td>
						
							<td>
								<select id="cmbMateriaPrima">
									<c:forEach var="itemMateriaP" items="${materiasPrimas}">	
										<option value="${itemMateriaP.codigoMateriaPrima}">${itemMateriaP.descMateriaPrima}</option>	
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" value="Adicionar Materia Prima" id="btnAdicionarMateriaPrima"/>
							</td>
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


