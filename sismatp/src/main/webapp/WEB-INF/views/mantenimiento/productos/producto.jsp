<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/implast/js/mantenimiento/producto.js"></script>
<div class="container">
		<div class="row">
			<p>Mantenimiento de Producto</p>
			
				<form id="frmInputProducto">
					<table>
						<tbody>
						<tr>
							<td><label>Código Producto:</label></td>
							<td><input type="text" id="txtCodigoProducto"></td>
						</tr>
						<tr>
							<td><label>Descripción Producto</label></td>
							<td><input type="text" id="txtDescripcionProducto"></td>
						</tr>
						</tbody>
					</table>
					<br>
					<input type="button" value="Registrar Producto">
					<input type="button" value="Cancelar Registro">
				</form>
				
				<br>
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_producto"></table>
						<div id="pgrilla_mantenimiento_producto"></div>
					</div>
				</div>
		</div>
</div>
