<!-- begin proveedor.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/mantenimiento/proveedor.js"></script>

<!-- <div id="body" style="margin:0 auto 0 auto ;width: 800px;"> -->
<div class="container">	
	<div class="row">
		<form action="" id="frmProveedo">
			<p>Registro Proveedores </p>
			<fieldset style="height: 70px;width: auto;">
				<legend>Ingreso de Datos</legend>
				<table>
					<tbody>
						<tr>
							<td><label>C�digo:</label></td>
							<td><input type="text" id="txtCodigo"></td>
						</tr>
						<tr>
							<td><label>Raz�n Social:</label></td>
							<td><input type="text" id="txtDescripcion"></td>
						</tr>
						<tr>
							<td><input type="button" id="btnRegistrarProveedor" title="Registrar" value="Registrar" /></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
</div>
<!-- end proveedor.jsp -->