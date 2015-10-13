/**
 * 
 */

$(document).ready(function(){
	
	$("#btnRegistrarProveedor").click(function(){
		registrarProveedor();
	});
});

function registrarProveedor(){
	var parametros=new Object();
	parametros.codigoProveedor=$("#txtCodigoProveedor").val();
	parametros.razonSocial=$("#txtNombreRazonSocial").val();
	
	$.ajax({
		url : 'registrarProveedor.json',
		data : parametros,
		dataType:'json',
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		alert("Recibi respuesta");
	});

}








