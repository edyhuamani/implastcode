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
							<td><label style="width: 150px;">Código Producto:</label></td>
							<td><input type="text" id="txtCodigoProducto" style="margin-left:10px; "></td>
						</tr>
						<tr>
							<td><label style="width: 150px">Descripción Producto:</label></td>
							<td><input type="text" id="txtDescripcionProducto" style="margin-left: 10px;"></td>
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
									<td>Materia Prima:</td>
									<td>
										<select id="cmbMateriaPrimaP" >
											<c:forEach var="itemMateriaPrima" items="${materiasPrimas}">
												<option value="${itemMateriaPrima.codigoMateriaPrima}">${itemMateriaPrima.descMateriaPrima}</option>
											</c:forEach>
										</select>
									</td>
									
								</tr>
								<tr>
									<td>Porcentaje:</td>
									<td><input type="text" id="txtPorcenMateriaP" style="margin-left:10px;"></td>
								</tr>
								<tr>
									<td>Cantidad:</td>
									<td><input type="text" id="txtCantMateriaP" style="margin-left:10px;"></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
				
				<input type="button" value="Registrar Mat.Prima en Mezcla" id="btnAdicionarMatPrimaMezcla">
				<input type="button" value="Cancelar" id="">

				<br>
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_mezcla"></table>
						<div id="pgrilla_mantenimiento_mezcla"></div>
					</div>
				</div>
				
				<input type="button" value="Registrar Producto">
				<input type="button" value="Cancelar Registro">
				
				<br>
				<div class="ready">
					<div>
						<table id="grilla_mantenimiento_producto"></table>
						<div id="pgrilla_mantenimiento_producto"></div>
					</div>
				</div>
		</div>
</div>
