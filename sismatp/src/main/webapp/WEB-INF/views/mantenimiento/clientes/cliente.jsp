<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/implast/js/mantenimiento/cliente.js"></script>

<script type="text/javascript">
	$(function() {
		    
		$("input[type=submit], input[type=button], button").button()
		.click(function(event) {
			event.preventDefault();
		});
	});
</script>

<style>
.highlight
{
    border: 1px solid red !important;
}
</style>

<div class="container">
	<div class="row">

		<div id="inputFields">
			<h4>Mantenimiento de Clientes</h4>
			<form action="" id="frmClientes">
						
						<fieldset style="height: 0 auto ;width: 0 auto;">
							<legend>Ingreso de Datos</legend>
							<table>
								<tbody>
									<tr>
										<td><label>Código Cliente: </label></td>
										<td><input type="text" id="txtCodigoCliente" maxlength="200" style="margin-left: 15px;"  /></td>
									</tr>
									
									<tr>
										<td><label>Razón Social :</label></td>
										<td><input type="text" id="txtRazonSocial"  maxlength="450" style="margin-left: 15px;"  /></td>
									</tr>
									
									<tr>
										<td><label>RUC:</label></td>
										<td><input type="text" id="txtRucCliente"  maxlength="250" style="margin-left: 15px;"/></td>
									</tr>
									
									<tr>
										<td><label>Telefono:</label></td>
										<td><input type="text" id="txtTelefono"  maxlength="250" style="margin-left: 15px;"/></td>
									</tr>
									
									<tr>
										<td><label>Nombres Contacto:</label></td>
										<td><input type="text" id="txtNombreContacto"  maxlength="450" style="margin-left: 15px;"/></td>
									</tr>
									
									<tr>
										<td><label>Apellidos Contacto:</label></td>
										<td><input type="text" id="txtApellidosContacto"  maxlength="450" style="margin-left: 15px;"/></td>
									</tr>
									
									
									<tr>
										<td><input type="button" id="btnRegistrarCliente" name="registrar"
											title="Registrar" value="Registrar"></td>
										<td><input type="button" id="btnCancelarRegistroCliente" name="cancelar"
											title="Cancelar" value="Cancelar"></td>
									</tr>
								</tbody>
							</table>
						</fieldset>
			</form>
		</div>
		
		<div class="ready">
			<div>
				<table id="grilla_mantenimiento_cliente"></table>
				<div id="pgrilla_mantenimiento_cliente"></div>
			</div>
		</div>
			
	</div>
</div>
