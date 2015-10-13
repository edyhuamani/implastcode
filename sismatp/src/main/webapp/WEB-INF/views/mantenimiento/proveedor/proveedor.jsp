<!-- begin proveedor.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/mantenimiento/proveedor.js"></script>

<!-- <div id="body" style="margin:0 auto 0 auto ;width: 800px;"> -->
<div class="container">	
	<div class="row">
		
		<div class="panel panel-default">
			<form action="" id="frmProveedo">
				<p>Registro Proveedores </p>
				<fieldset style="height: 70px;width: auto;">
					<legend>Ingreso de Datos</legend>
					<table>
						<tbody>
							<tr>
								<td><label>Código Proveedor:</label></td>
								<td><input type="text" id="txtCodigoProveedor"></td>
							</tr>
							<tr>
								<td><label>Razón Social (Nombre):</label></td>
								<td><input type="text" id="txtNombreRazonSocial"></td>
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
</div>
<!-- end proveedor.jsp -->