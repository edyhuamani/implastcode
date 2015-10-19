<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="<%=request.getContextPath()%>/implast/js/mantenimiento/operador.js"></script>
<script type="text/javascript">
$(function() {
	$( "#listProveedores" )
	.selectmenu()
	.selectmenu("menuWidget")
  	.addClass( "overflow" );

	    
	$("input[type=submit], input[type=button], button").button()
	.click(function(event) {
		event.preventDefault();
	});
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<div id="body" >
	<div class="container">
		<div class="row">
			<p>Registro Mantenimiento Operador </p>
			<fieldset>
				<legend>Operadores</legend>
					<form id="frmOperador">
						
							<table>
								<tr>
									<td><label>Codigo Operador:</label></td>
									<td><input type="text" id="txtCodigoOperador"></td>
								</tr>
								<tr>
									<td><label>Nombre Operador:</label></td>
									<td><input type="text" id="txtNombreOperador"></td>
								</tr>
							</table>
							<input type="submit" id="btnRegistrarOperador" value="Registrar Operador">
					</form>
			</fieldset>
			
			
			<!-- grilla proveedor-->
			<fieldset>
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_operador"></table>
						<div id="pgrilla_mantenimiento_operador"></div>
					</div>
				</div>
			</fieldset>
			<!-- fin grilla proveedor-->
		</div>
	</div>
</div>