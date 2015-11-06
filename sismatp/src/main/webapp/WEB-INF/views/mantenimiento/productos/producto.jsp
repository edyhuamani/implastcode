<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/implast/js/mantenimiento/producto.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/implast/js/mantenimiento/productoMezcla.js"></script>
<script type="text/javascript"> 
	$(function() {
		$( "#cmbMateriaPrimaP" )
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
			<p>Mantenimiento de Producto</p>
				
				<form id="frmInputProducto">
					<table>
						<tbody>
						<tr>
							<td><label style="width: 150px;">Código :</label></td>
							<td><input type="text" id="txtCodigoProducto" style="margin-left:10px;width: 150px;" ></td>
						</tr>
						<tr>
							<td><label style="width: 150px">Descripción :</label></td>
							<td><input type="text" id="txtDescripcionProducto" style="margin-left: 10px;width: 450px;" ></td>
						</tr>
						</tbody>
					</table>
					<br>
					
				</form>
				
				<p>Definición de Mezcla:</p>
				<form>
					<fieldset>
						<table>
							<tbody>
								<tr>
									<td><label style="width: 150px;">Materia Prima:</label></td>
									<td>
										<select id="cmbMateriaPrimaP"  style="margin-left:10px;">
											<c:forEach var="itemMateriaPrima" items="${materiasPrimas}">
												<option value="${itemMateriaPrima.codigoMateriaPrima}"  style="margin-left:10px;">${itemMateriaPrima.descMateriaPrima}</option>
											</c:forEach>
										</select>
									</td>
									
								</tr>
								<tr>
									<td><label style="width: 150px;">Porcentaje:</label></td>
									<td><input type="text" id="txtPorcenMateriaPrima"  value="0.00"></td>
								</tr>
								<tr>
									<td><label style="width: 150px;">Cantidad:</label></td>
									<td><input type="text" id="txtCantMateriaPrima"  value="0.00"></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
				<br>
				
				<input type="button" value="Registrar Mat.Prima en Mezcla" id="btnAdicionarMatPrimaIngrediente">
				<input type="button" value="Cancelar" id="btnCancelarRegistroIngrediente">

				<br>
				<br>
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_mezcla"></table>
						<div id="pgrilla_mantenimiento_mezcla"></div>
					</div>
				</div>
				<br>
				<input type="button" value="Registrar Producto" id="btnRegistrarProducto">
				<input type="button" value="Cancelar Registro" id="btnCancelarRegistroProducto">
				<br>
				<br>
				
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_producto"></table>
						<div id="pgrilla_mantenimiento_producto"></div>
					</div>
				</div>
		</div>
</div>
