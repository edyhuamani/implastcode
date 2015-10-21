<!-- begin proveedor.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/mantenimiento/proveedor.js"></script>

<script type="text/javascript">
	$(function(){

		$("input[type=submit], input[type=button], button").button()
			.click(function(event) {
			event.preventDefault();
		});
	
	});

</script>

<div class="container">	
	<div class="row">
		
		<div class="panel panel-default">
			<form action="" id="frmProveedo">
				<p>Mantenimiento de  Proveedores </p>
				<fieldset style="height: 0 auto ;width: 0 auto;">
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
		
		<!-- grilla proveedor-->
		<div class="ready">
				<div>
					<table id="grilla_mantenimiento_proveedor"></table>
					<div id="pgrilla_mantenimiento_proveedor"></div>
				</div>
		</div>
		<!-- fin grilla proveedor -->
		
	</div>
</div>
<!-- end proveedor.jsp -->