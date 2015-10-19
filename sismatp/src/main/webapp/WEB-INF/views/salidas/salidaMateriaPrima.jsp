<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/procesos/salidaMateriaPrima.js"></script>
	
	<div id="body">
		<div class="container">
			<div class="row">
				<h3>Registro de Salidas de Materias Primas</h3>
				<table>
					<tr>
						<td>	
							<label>
								Seleccione Materia Prima:
							</label>
						</td>
						<td>	
							<select id="cmbCodigoMateriaPrima">
								<c:forEach var="itemMateriaPrima" items="${materiasPrimas}">
									<option value="itemMateriaPrima.codigoMateriaPrima">				
										
										itemMateriaPrima.
									
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
					
					</tr>
				</table>
			</div>
		</div>
	</div>
