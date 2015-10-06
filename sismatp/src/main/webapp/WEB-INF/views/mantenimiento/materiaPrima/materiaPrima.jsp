<!-- begin materiaPrima.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/mantenimiento/materiaPrima.js"></script>

<div id="body" style="margin-left: 0">
	
	<!-- <div style="margin: 0 auto 0 auto;width: 800px; ">-->
	<div class="container"> 
		<div class="row">
			<p>Registro Creación de Materias Primas </p>
			
			<form action="" id="frmMateriaPrima">
				<fieldset style="height: 70px;width: auto;">
					<legend>Ingreso de Datos</legend>
					<table>
						<tbody>
							<tr>
								<td><label>Código: </label></td>
								<td><input type="text" id="txtCodigo" /></td>
							</tr>
							<tr>
								<td><label>Descripción:</label></td>
								<td><input type="text" id="txtDescripcion" /></td>
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
	</div>
	
</div>
<!-- end materiaPrima.jsp -->