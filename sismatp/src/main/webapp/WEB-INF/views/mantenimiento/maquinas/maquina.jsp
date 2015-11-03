<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/implast/js/mantenimiento/maquina.js"></script>

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
<div class="container">

	<div class="row">
		<p>Mantenimiento de Maquinas</p>
	</div>
	
	<div class="ready">
		<fieldset>
		<table>
			<tr>
				<td><label>Código Maquina</label></td>
				<td><input type="text" id="txtCodigoMaquina" style="margin-left: 10px"></td>
			</tr>
			<tr>
				<td><label>Descripcion Maquina:</label></td>
				<td><input type="text" id="txtDescripcionMaquina" style="margin-left: 10px"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Registrar Maquina" id="btnRegistrarMaquina"></td>
				<td><input type="submit" value="Cancelar" id="btnCancelarMaquina"></td>
			</tr>
		</table>
		</fieldset>
		<br>
		<br>
		<div>
			<table id="grilla_mantenimiento_maquina"></table>
			<div id="pgrilla_mantenimiento_maquina"></div>
		</div>
	
	</div>
	
</div>